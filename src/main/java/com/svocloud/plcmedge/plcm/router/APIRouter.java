package com.svocloud.plcmedge.plcm.router;

import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.plcm.service.RMService;

import io.vertx.ext.web.Router;

public class APIRouter {
	
	private DMAService dMAService;
	private RMService rMService;
	
	public Router wrapRouter(Router router){
		
		/** DMA handle*/
		router.get("/plcm/api/rest").handler(rMService::test);
		
		/** RM handle*/
		router.get("/").handler(rMService::test);
		router.post("/").handler(rMService::test);
		router.put("/").handler(rMService::test);
		router.delete("/").handler(rMService::test);
		
		return router;
	}
}
