package com.svocloud.plcmedge.plcm.service;

import java.util.List;
import com.svocloud.plcmedge.plcm.model.ConferenceRoom;

public interface DMAService {
	
	boolean createConferenceRoom();
	ConferenceRoom getConferenceRoom();
	ConferenceRoom updateConferenceRoom();
	ConferenceRoom deleteConferenceRoom();
	List<ConferenceRoom> getConferenceRooms();
	
}
