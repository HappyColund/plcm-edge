package com.svocloud.plcmedge.plcm.service;

import java.util.List;

import com.svocloud.plcmedge.plcm.model.Conference;
import com.svocloud.plcmedge.plcm.model.ConferenceRoom;
import com.svocloud.plcmedge.utils.HttpsClientUtils;

public class PlcmDriverImpl implements PlcmDriver{

	@Override
	public ConferenceRoom getConferenceRoomById(String roomId) {
		return null;
	}

	@Override
	public boolean updateConferenceRoom(String roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteConferenceRoom(String roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ConferenceRoom> getConferenceRooms() {
		return null;
	}

	@Override
	public boolean createConferenceRoom(ConferenceRoom room) {
		return false;
	}

	@Override
	public List<ConferenceRoom> getConferenceRoomsByParameters(ConferenceRoom parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conference> getConferences() {
		return null;
	}

}
