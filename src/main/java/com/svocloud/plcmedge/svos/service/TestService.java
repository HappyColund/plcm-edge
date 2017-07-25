package com.svocloud.plcmedge.svos.service;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

@VertxGen
@ProxyGen
public interface TestService {
	
	 String SERVICE_NAME = "TestService-eb-service";
	 String SERVICE_ADDRESS="TestService-eb-addr";
	 
	 @Fluent//no blocked
	 void insert(String sql,JsonObject document,Handler<AsyncResult<JsonObject>> result );
}
