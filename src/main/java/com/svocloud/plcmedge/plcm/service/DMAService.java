package com.svocloud.plcmedge.plcm.service;

import java.util.List;

import com.svocloud.plcmedge.plcm.model.MCU;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

@VertxGen
@ProxyGen
public interface DMAService {
	
	/**
	 * The address on which the service is published.
	 */
	String SERVICE_ADDRESS = "SERVERCE.DMA.ADDRESS";	
	
	String SERVICE_NAME = "SERVERCE.DMA.NAME";	
	
	 @Fluent
	 DMAService getMcus(RoutingContext routingContext);
}
