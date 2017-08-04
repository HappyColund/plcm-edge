package com.svocloud.plcmedge.plcm.service;

import java.util.List;

import com.svocloud.plcmedge.plcm.model.Conference;
import com.svocloud.plcmedge.plcm.model.ConferenceRoom;

public interface PlcmDriver {
	
	boolean createConferenceRoom(ConferenceRoom room);
	ConferenceRoom getConferenceRoomById(String roomId);
	boolean updateConferenceRoom(String roomId);
	boolean deleteConferenceRoom(String roomId);
	List<ConferenceRoom> getConferenceRooms();
	List<ConferenceRoom> getConferenceRoomsByParameters(ConferenceRoom parameters);
	List<Conference> getConferences();
}
