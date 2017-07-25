package com.svocloud.plcmedge.svos.service.impl;

import com.svocloud.plcmedge.svos.jdbcRepository.JdbcRepositoryWrapper;
import com.svocloud.plcmedge.svos.service.TestService;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;


public class TestServiceImpl extends JdbcRepositoryWrapper implements TestService {

	public TestServiceImpl(Vertx vertx, JsonObject config) {
		super(vertx, config);
	}

	@Override
	public void insert(String sql, JsonObject document, Handler<AsyncResult<JsonObject>> result) {
		
	}

}
