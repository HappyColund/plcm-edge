package com.svocloud.plcmedge.plcm.service.impl;

import com.svocloud.plcmedge.commons.Constants;
import com.svocloud.plcmedge.commons.Result;
import com.svocloud.plcmedge.enums.ResultEnum;
import com.svocloud.plcmedge.plcm.model.PlcmMcu;
import com.svocloud.plcmedge.plcm.model.PlcmMcuList;
import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.utils.SendUtil;
import com.svocloud.plcmedge.utils.StringUtils;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.redis.RedisClient;

public class DMAServiceImpl implements DMAService {
	
	
	private WebClient webClient = null;
	private RedisClient redisClient = null;
	
	public DMAServiceImpl(Vertx vertx, JsonObject config) {
		webClient = WebClient.create(vertx, new WebClientOptions().setSsl(true).setKeepAlive(false).
				setConnectTimeout(2000).setTrustAll(true));
	}
	@Override
	public void mcuRetrieveAll(RoutingContext routingContext) {
		webClient.getAbs(Constants.DMA_MCU_LIST)
		.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=")
		.putHeader("Accept", "application/vnd.plcm.plcm-mcu-list+json")
		.send(r->{
			Result result = null;
			if(r.succeeded()){
				try{
					if(r.result().statusCode()==200)
						result = new  Result(r.result().bodyAsJson(PlcmMcuList.class));
				}catch(Exception e){
					result = new Result(ResultEnum.INTERNAL_ERROR);
					e.printStackTrace();
				}
			}else{
				result = new Result(ResultEnum.INTERNAL_ERROR);
			}
			SendUtil.send(routingContext, result);
		});
	}
	@Override
	public void mcuRetrieveOne(RoutingContext routingContext) {
		String id = routingContext.request().getParam("id");
		if(StringUtils.isEmpty(id)){
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
			return;
		}
		HttpRequest<Buffer> abs = webClient.getAbs(Constants.DMA_MCU_ONE);
		abs.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=");
		abs.putHeader("Accept", "application/vnd.plcm.plcm-mcu+json");
		abs.send(r->{
			Result result = null;
			if(r.succeeded()){
				try{
					if(r.result().statusCode()==200)
						result = new  Result((PlcmMcu) r.result().bodyAsJson(PlcmMcu.class).setAtomLinkList(null));
					if(r.result().statusCode()==404)
						result = new Result(ResultEnum.NOT_FOUND);
				}catch(Exception e){
					e.printStackTrace();
					result = new Result(ResultEnum.INTERNAL_ERROR);
				}
			}else{
				result = new Result(ResultEnum.INTERNAL_ERROR);
				r.cause().printStackTrace();
			}
			SendUtil.send(routingContext, result);
		});
	}
	@Override
	public void startConference(RoutingContext routingContext) {
	}
	@Override
	public void createConferenceRoom(RoutingContext routingContext) {
		
	}
	@Override
	public void deleteConference(RoutingContext routingContext) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void endConference(RoutingContext routingContext) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void subscribeConference(RoutingContext routingContext) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void lockConference(RoutingContext routingContext) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unlockConference(RoutingContext routingContext) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void muteConference(RoutingContext routingContext) {
		String cid = routingContext.request().getParam("id");
		if(StringUtils.isEmpty(cid))
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
	}
	@Override
	public void unMuteConference(RoutingContext routingContext) {
		
		String cid = routingContext.request().getParam("id");
		if(StringUtils.isEmpty(cid))
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
		else{
			webClient.postAbs(Constants.API_CONFERENCE_UNMUTE.replace(":id", cid))
			.putHeader("Authorization", "Basic YWRtaW46IVFBWnhzdzI=")
			.send(ar->{
				System.out.println("DMA request URL:<"+Constants.API_CONFERENCE_UNMUTE.replace(":id", cid)+">");
				System.out.println(ar.succeeded());
				System.out.println(ar.result().statusCode());
				if(ar.succeeded()&&ar.result().statusCode()==204)
					SendUtil.send(routingContext, new Result());
				else
					SendUtil.send(routingContext, new Result(ResultEnum.INTERNAL_ERROR));
			});
		}
	}
	@Override
	public void startRecord(RoutingContext routingContext) {
		String cid = routingContext.request().getParam("cid");
		if(StringUtils.isEmpty(cid)){
			SendUtil.send(routingContext, new Result(ResultEnum.PARAMNOTFOUNT));
			return;
		}
		webClient.getAbs("")
		.send(ar->{
			if(ar.succeeded()&&ar.result().statusCode()==200){
				SendUtil.send(routingContext, new Result());
			}else
				SendUtil.send(routingContext, new Result(ResultEnum.INTERNAL_ERROR));
		});
	}
	@Override
	public void endRecord(RoutingContext routingContext) {
		String cid = routingContext.request().getParam("cid");
		if(StringUtils.isEmpty(cid))
			SendUtil.send(routingContext, new Result(ResultEnum.NOT_FOUND));
		else{
			webClient.getAbs("").send(ar->{
				if(ar.succeeded()&&(ar.result().statusCode()==200))
					SendUtil.send(routingContext, new Result());
				else
					SendUtil.send(routingContext, new Result(ResultEnum.INTERNAL_ERROR));
			});
		}
	}
}
