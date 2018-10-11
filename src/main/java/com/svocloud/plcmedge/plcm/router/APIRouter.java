package com.svocloud.plcmedge.plcm.router;

import com.svocloud.plcmedge.plcm.service.DMAService;
import com.svocloud.plcmedge.plcm.service.RMService;

import io.vertx.ext.web.Router;

public class APIRouter {
	
	private DMAService dMAService;
	private RMService rMService;
	
	public Router wrapRouter(Router router){
		
		router.get("/plcm/api/rest/mcus").handler(null);
		router.get("/plcm/api/rest/mcus/mcu-identifier").handler(null);
		
		router.get("/plcm/api/rest/mcu-pools").handler(null);
		router.get("/plcm/api/rest/mcu-pools/mcu-pool-identifier").handler(null);
		
		router.get("/plcm/api/rest/mcu-pool-orders").handler(null);
		router.get("/plcm/api/rest/mcu-pool-orders/mcu-pool-order-identifier").handler(null);
		
		router.get("/plcm/api/rest/conference-rooms").handler(null);
		router.post("/plcm/api/rest/conference-rooms").handler(null);
		router.get("/plcm/api/rest/conference-rooms/conference-room-identifier").handler(null);
		router.put("/plcm/api/rest/conference-rooms/conference-room-identifier").handler(null);
		router.delete("/plcm/api/rest/conference-rooms/conference-room-identifier").handler(null);
		
		/** RM handle sss */
		router.get("/").handler(rMService::test);
		router.post("/").handler(rMService::test);
		router.put("/").handler(rMService::test);
		router.delete("/").handler(rMService::test);
		
		return router;
	}
}
