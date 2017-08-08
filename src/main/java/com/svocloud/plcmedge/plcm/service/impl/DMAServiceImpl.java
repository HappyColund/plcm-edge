package com.svocloud.plcmedge.plcm.service.impl;

import com.svocloud.plcmedge.commons.Constants;
import com.svocloud.plcmedge.commons.Result;
import com.svocloud.plcmedge.enums.ResultEnum;
import com.svocloud.plcmedge.plcm.model.PlcmError;
import com.svocloud.plcmedge.plcm.model.PlcmMcu;
import com.svocloud.plcmedge.plcm.model.PlcmMcuList;
import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.utils.SendUtil;
import com.svocloud.plcmedge.utils.StringUtils;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.redis.RedisClient;

public class DMAServiceImpl implements DMAService {
	
	private static final Logger logger = LoggerFactory.getLogger(DMAService.class); 
	
	private WebClient webClient = null;
	private RedisClient redisClient = null;
	
	public DMAServiceImpl(Vertx vertx, JsonObject config) {
		webClient = WebClient.create(vertx, new WebClientOptions().setSsl(true).setKeepAlive(false).
				setConnectTimeout(2000).setTrustAll(true));
	}
	@Override
	public void mcuRetrieveAll(RoutingContext routingContext) {
		webClient.getAbs(Constants.MCU_LIST)
		.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=")
		.putHeader("Accept", "application/vnd.plcm.plcm-mcu-list+json")
		.as(BodyCodec.json(PlcmMcuList.class))
		.send(r->{
			Result result = null;
			if(r.succeeded()){
				try{
					PlcmMcuList plcmMcuList = r.result().body();
					result = new  Result(plcmMcuList);
					SendUtil.send(routingContext, result);
				}catch(Exception e){
					result = new Result(ResultEnum.INTERNAL_ERROR);
					SendUtil.send(routingContext, result);
					e.printStackTrace();
				}
				
			}else{
				result = new Result(ResultEnum.INTERNAL_ERROR);
			}
		});
	}
	@Override
	public void mcuRetrieveOne(RoutingContext routingContext) {
		String id = routingContext.request().getParam("id");
		if(StringUtils.isEmpty(id)){
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
			return;
		}
		System.out.println("id="+id);
		webClient.getAbs(Constants.MCU_LIST+"/"+id)
		.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=")
		.putHeader("Accept", "application/vnd.plcm.plcm-mcu+json;application/vnd.plcm.plcm-error+json")
		.send(r->{
			if(r.succeeded()){
				System.out.println("888888");
				Result result = null;
				Object body = new Object();
				if(r.result().statusCode()==200){
					body = (PlcmMcu) r.result().bodyAsJson(PlcmMcu.class);
				}else{
					body = r.result().bodyAsJson(PlcmError.class);
				}
				System.out.println(body);
				result = new  Result(body);
				SendUtil.send(routingContext, result);
			}else{
				System.out.println("22222");
				r.cause().printStackTrace();
			}
		});
	}
	@Override
	public void startConference(RoutingContext routingContext) {
	}
	@Override
	public void createConferenceRoom(RoutingContext routingContext) {
		
	}
	@Override
	public void startRecord(RoutingContext routingContext) {
		
		String cid = routingContext.request().getParam("cid");
		if(StringUtils.isEmpty(cid)){
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
			return;
		}
		logger.info("开始录制...");
		webClient.getAbs("")
		.send(ar->{
			if(ar.succeeded()){
				if(ar.result().statusCode()==200){
					SendUtil.send(routingContext, new Result());
				}else{
					SendUtil.send(routingContext, new Result(ResultEnum.INTERNAL_ERROR));
				}
			}else{
				SendUtil.send(routingContext, new Result(ResultEnum.INTERNAL_ERROR,"ar.Cause"));
			}
			
		});
	}
}
