package com.svocloud.plcmedge.plcm;

import com.svocloud.plcmedge.plcm.router.APIRouter;
import com.svocloud.plcmedge.verticle.RestVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class RestApiVerticle extends RestVerticle{
	@Override
	public void start(Future<Void> future) throws Exception {
		// 注册服务
		super.start();
		Router router = Router.router(vertx);
		enableCorsSupport(router);
		// 绑定handler
		new APIRouter().wrapRouter(router);
		// 创建httpserver并发布服务
		createHttpServer(router, "localhost", 8080).compose(serverPublish -> publishHttpEndpoint("plcm-rest-api", "localhost", 8888))
				.setHandler(future.completer());
	}

	
}
