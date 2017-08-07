package com.svocloud.plcmedge.plcm;

import com.hazelcast.config.Config;
import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.plcm.service.impl.DMAServiceImpl;
import com.svocloud.plcmedge.utils.Runner;
import com.svocloud.plcmedge.verticle.RestVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RestApiVerticle extends RestVerticle{
	
	private static final String SERVICE_NAME = "plcm-rest-api";
	
	private DMAService dMAService;
	
	private final String API_MCU_RETRIEVE_ALL="/mcus";
	
	public RestApiVerticle(DMAService dMAService){
		this.dMAService=dMAService;
	}
	public RestApiVerticle(){}
	@Override
	public void start(Future<Void> future) throws Exception {
		// 注册服务
		super.start();
		final Router router = Router.router(vertx);
		enableCorsSupport(router);
		// create HTTP server and publish REST service
		router.get(API_MCU_RETRIEVE_ALL).handler(this::mcuRetrieveAll);
	    createHttpServer(router, "localhost", 8080)
	      .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, "localhost", 8080))
	      .setHandler(future.completer());
	}
	
	private void mcuRetrieveAll(RoutingContext routingContext){
		dMAService.getMcus(routingContext);
	}
	
	public static void main(String[] args) {
		//Runner.run(RestApiVerticle.class, new VertxOptions(), new DeploymentOptions());
		Vertx vertx = Vertx.vertx();
		RestApiVerticle restApiVerticle = new RestApiVerticle(new DMAServiceImpl(vertx, null));
		vertx.deployVerticle(restApiVerticle);
	}
}
