package com.svocloud.plcmedge.verticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.circuitbreaker.CircuitBreakerOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.impl.ConcurrentHashSet;
import io.vertx.core.json.JsonObject;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;

public abstract class BaseVerticle extends AbstractVerticle {
	protected ServiceDiscovery discovery;
	protected CircuitBreaker circuitBreaker;
	protected Set<Record> registeredRecords = new ConcurrentHashSet<Record>();

	@Override
	public void start(Future<Void> startFuture) throws Exception {

		discovery = ServiceDiscovery.create(vertx, new ServiceDiscoveryOptions().setBackendConfiguration(config()));

		JsonObject cbOptions = config().getJsonObject("circuit-breaker") != null
				? config().getJsonObject("circuit-breaker") : new JsonObject();
		circuitBreaker = CircuitBreaker.create(cbOptions.getString("name", "circuit-breaker"), vertx,
				new CircuitBreakerOptions().setMaxFailures(cbOptions.getInteger("max-failures", 5))
						.setTimeout(cbOptions.getLong("timeout", 10000L)).setFallbackOnFailure(true)
						.setResetTimeout(cbOptions.getLong("reset-timeout", 30000L)));
	}

	@Override
	public void stop(Future<Void> stopFuture) throws Exception {
		List<Future> futures = new ArrayList<>();
		registeredRecords.forEach(record -> {
			Future<Void> cleanupFuture = Future.future();
			futures.add(cleanupFuture);
			discovery.unpublish(record.getRegistration(), cleanupFuture.completer());
		});

		if (futures.isEmpty()) {
			discovery.close();
			stopFuture.complete();
		} else {
			CompositeFuture.all(futures).setHandler(ar -> {
				discovery.close();
				if (ar.failed()) {
					stopFuture.fail(ar.cause());
				} else {
					stopFuture.complete();
				}
			});
		}
	}

}
