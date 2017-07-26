package com.svocloud.plcmedge.utils;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import java.util.function.Consumer;

public class Runner {
	
	private Runner(){}
	
	/**
	 * 
	 * @param clazz  verticle实例
	 * @param vertxOptions  Vertx 配置
	 * @param deploymentOptions
	 */
	public static void run(Class<?> clazz, VertxOptions vertxOptions, DeploymentOptions deploymentOptions) {
		String verticleID = clazz.getName();
		System.setProperty("vertx.cwd", "/");
		Consumer<Vertx> runner = vertx -> {
			try {
				if (deploymentOptions != null) {
					vertx.deployVerticle(verticleID, deploymentOptions);
				} else {
					vertx.deployVerticle(verticleID);
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		};
		if (vertxOptions.isClustered()) {
			Vertx.clusteredVertx(vertxOptions, res -> {
				if (res.succeeded()) {
					Vertx vertx = res.result();
					runner.accept(vertx);
				} else {
					res.cause().printStackTrace();
				}
			});
		} else {
			Vertx vertx = Vertx.vertx(vertxOptions);
			runner.accept(vertx);
		}
	}

}
