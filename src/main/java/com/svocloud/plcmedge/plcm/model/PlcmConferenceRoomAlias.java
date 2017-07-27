package com.svocloud.plcmedge.plcm.model;

import com.svocloud.plcmedge.enums.ConferenceRoleEnum;

public class PlcmConferenceRoomAlias {
	
	private String alias;
	
	private String ConferenceRole;
	
	private String conferenceRoleEnum;

	public String getAlias() {
		return alias;
	}

	public PlcmConferenceRoomAlias setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	public String getConferenceRole() {
		return ConferenceRole;
	}

	public PlcmConferenceRoomAlias setConferenceRole(String conferenceRole) {
		ConferenceRole = conferenceRole;
		return this;
	}

	public String getConferenceRoleEnum() {
		return conferenceRoleEnum;
	}

	public PlcmConferenceRoomAlias setConferenceRoleEnum(String conferenceRoleEnum) {
		this.conferenceRoleEnum = conferenceRoleEnum;
		return this;
	}
	
	
}
