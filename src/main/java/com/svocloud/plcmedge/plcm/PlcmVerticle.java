package com.svocloud.plcmedge.plcm;

import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.plcm.service.impl.DMAServiceImpl;
import com.svocloud.plcmedge.verticle.BaseVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ProxyHelper;
import static  com.svocloud.plcmedge.plcm.service.DMAService.SERVICE_ADDRESS;
import static  com.svocloud.plcmedge.plcm.service.DMAService.SERVICE_NAME;;

public class PlcmVerticle extends BaseVerticle {

	private DMAService dMAService;
	@Override
	public void start(Future<Void> future) throws Exception {
		super.start();
		dMAService = new DMAServiceImpl(vertx, config());
		ProxyHelper.registerService(DMAService.class, vertx, dMAService, SERVICE_ADDRESS);
		publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, DMAService.class).
		compose(servicePublished -> deployRestVerticle())
	      .setHandler(future.completer());
	}
	
	 private Future<Void> deployRestVerticle() {
		 Future<String> future = Future.future();
		 vertx.deployVerticle(new RestApiVerticle(dMAService),
		 new DeploymentOptions().setConfig(config()),
         future.completer());
         return future.map(r -> null);
  }
}
