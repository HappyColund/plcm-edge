package com.svocloud.plcmedge;

import java.io.File;
import java.io.IOException;

import com.svocloud.plcmedge.plcm.RestApiVerticle;
import com.svocloud.plcmedge.utils.Runner;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		
		VertxOptions vertxOptions = new VertxOptions().setClustered(false);
		Runner.run(RestApiVerticle.class, vertxOptions, null);
	}
}
