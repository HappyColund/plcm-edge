package com.svocloud.plcmedge.plcm.service.impl;

import java.util.List;

import com.hazelcast.util.JsonUtil;
import com.svocloud.plcmedge.commons.Constants;
import com.svocloud.plcmedge.commons.Result;
import com.svocloud.plcmedge.plcm.model.MCU;
import com.svocloud.plcmedge.plcm.model.PlcmMcuList;
import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.utils.SendUtil;

import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;

public class DMAServiceImpl implements DMAService {
	
	private WebClient webClient = null;
	
	public DMAServiceImpl(Vertx vertx, JsonObject config) {
		webClient = WebClient.create(vertx, new WebClientOptions().setSsl(true).setKeepAlive(false).
				setConnectTimeout(2000).setTrustAll(true));
	}
	@Override
	public DMAService getMcus(RoutingContext routingContext) {
		HttpRequest<Buffer> req = webClient.getAbs(Constants.MCU_LIST);
		req.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=")
		.putHeader("Accept", "application/vnd.plcm.plcm-mcu-list+json")
		.as(BodyCodec.json(PlcmMcuList.class))
		.send(r->{
			Result result = null;
			if(r.succeeded()){
				PlcmMcuList plcmMcuList = (PlcmMcuList) r.result().body();
				System.out.println(plcmMcuList.toString());
				result = new  Result(plcmMcuList);
				System.out.println(plcmMcuList.toString());
				SendUtil.send(routingContext, result);
			}else{
				r.cause().printStackTrace();
			}
		});
		return this;
	}


}
