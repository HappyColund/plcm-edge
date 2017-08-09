package com.svocloud.plcmedge.plcm.service;

import io.vertx.ext.web.RoutingContext;

public interface DMAService {
	
	/**
	 * The address on which the service is published.
	 */
	String SERVICE_ADDRESS = "SERVERCE.DMA.ADDRESS";	
	
	String SERVICE_NAME = "SERVERCE.DMA.NAME";	
	
	void mcuRetrieveAll(RoutingContext routingContext);
	 
	void mcuRetrieveOne(RoutingContext routingContext);
	
	void startConference(RoutingContext routingContext);
	
	void deleteConference(RoutingContext routingContext);
	
	void endConference(RoutingContext routingContext);
	
	void subscribeConference(RoutingContext routingContext);
	
	void lockConference(RoutingContext routingContext);
	
	void unlockConference(RoutingContext routingContext);
	
	void muteConference(RoutingContext routingContext);
	
	void unMuteConference(RoutingContext routingContext);
	
	void createConferenceRoom(RoutingContext routingContext);
	
	void startRecord(RoutingContext routingContext);
	
	void endRecord(RoutingContext routingContext);
	
}
