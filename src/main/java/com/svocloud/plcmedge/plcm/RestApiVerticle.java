package com.svocloud.plcmedge.plcm;

import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.plcm.service.impl.DMAServiceImpl;
import com.svocloud.plcmedge.verticle.RestVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class RestApiVerticle extends RestVerticle{
	
	private static final String SERVICE_NAME = "plcm-rest-api";
	
	private DMAService dMAService;
	
	private final String API_MCU_RETRIEVE_ALL="/api/rest/mcus";
	private final String API_MCU_RETRIEVE_NOE="/api/rest/mcus/:id";
	private final String API_CONFERENCE_START="/api/rest/conferences/:id/startConference";
	private final String API_RECORD_START="/api/rest/conferences/:id/startRecord";
	
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
		router.get(API_MCU_RETRIEVE_ALL).handler(dMAService::mcuRetrieveAll);
		router.get(API_MCU_RETRIEVE_NOE).handler(dMAService::mcuRetrieveOne);
		//开始会议
		router.post(API_CONFERENCE_START).handler(dMAService::startConference);
		//开始录制
		router.post(API_RECORD_START).handler(dMAService::startRecord);
	    createHttpServer(router, "localhost", 8080)
	      .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, "localhost", 8080))
	      .setHandler(future.completer());
	}
	
	
	public static void main(String[] args) {
		//Runner.run(RestApiVerticle.class, new VertxOptions(), new DeploymentOptions());
		Vertx vertx = Vertx.vertx();
		RestApiVerticle restApiVerticle = new RestApiVerticle(new DMAServiceImpl(vertx, null));
		vertx.deployVerticle(restApiVerticle);
	}
}
