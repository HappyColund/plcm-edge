package com.svocloud.plcmedge.plcm.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.svocloud.plcmedge.utils.FieldCheckUtils;
import com.svocloud.plcmedge.utils.StringUtils;

public class ConferenceRoom {

	private List<Link> atomLinkList = new ArrayList<Link>();
	
	private List<PlcmConferenceRoomAlias> plcmConferenceRoomAliasList = new ArrayList<PlcmConferenceRoomAlias>();
	
	private PlcmDialOutParticipant plcmDialOutParticipant;
	
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerDomain;
	private String ownerUsername;
	private int durationInMinutes;
	private String conferenceRoomIdentifier;
	private String dialInNumber;
	private String conferenceTemplateName;
	private int maxParticipants;
	private String mcuPoolOrderName;
	private String territoryName;
	private boolean chairpersonRequired;
	private String chairpersonCode;
	private boolean chairpersonCodeUseAsAlias;
	private String conferenceCode;
	private boolean conferenceCodeUseAsAlias;
	private String entityTag;
	private String passback;
	private String passthru;
	private boolean autoDialOut;
	private String resourcePriorityNamespace;
	private String resourcePriorityValue;
	private boolean firstCallerMcuAffinity;
	private boolean confRoomPublishable;
	private boolean overrideLastDisconnect;
	private String focusUri;
	private String lyncRegisteredDomain;
	private LocalDateTime notBefore;
	private LocalDateTime notAfter;
	public List<Link> getAtomLinkList() {
		return atomLinkList;
	}
	public ConferenceRoom setAtomLinkList(List<Link> atomLinkList) {
		this.atomLinkList = atomLinkList;
		return this;
	}
	public List<PlcmConferenceRoomAlias> getPlcmConferenceRoomAliasList() {
		return plcmConferenceRoomAliasList;
	}
	public ConferenceRoom setPlcmConferenceRoomAliasList(List<PlcmConferenceRoomAlias> plcmConferenceRoomAliasList) {
		this.plcmConferenceRoomAliasList = plcmConferenceRoomAliasList;
		return this;
	}
	public PlcmDialOutParticipant getPlcmDialOutParticipant() {
		return plcmDialOutParticipant;
	}
	public ConferenceRoom setPlcmDialOutParticipant(PlcmDialOutParticipant plcmDialOutParticipant) {
		this.plcmDialOutParticipant = plcmDialOutParticipant;
		return this;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public ConferenceRoom setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = FieldCheckUtils.setField(this, ownerFirstName, 64);
		return this;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public ConferenceRoom setOwnerLastName(String ownerLastName) {
		this.ownerLastName = FieldCheckUtils.setField(this, ownerLastName, 64);
		return this;
	}
	public String getOwnerDomain() {
		return ownerDomain;
	}
	public ConferenceRoom setOwnerDomain(String ownerDomain) {
		this.ownerDomain = FieldCheckUtils.setField(this, ownerDomain, 0);
		return this;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public ConferenceRoom setOwnerUsername(String ownerUsername) {
		this.ownerUsername = FieldCheckUtils.setField(this, ownerUsername, 0);
		return this;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public ConferenceRoom setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
		return this;
	}
	public String getConferenceRoomIdentifier() {
		return conferenceRoomIdentifier;
	}
	public ConferenceRoom setConferenceRoomIdentifier(String conferenceRoomIdentifier) {
		this.conferenceRoomIdentifier = FieldCheckUtils.setField(this, conferenceRoomIdentifier, 128);
		return this;
	}
	public String getDialInNumber() {
		return dialInNumber;
	}
	public ConferenceRoom setDialInNumber(String dialInNumber) {
		this.dialInNumber = dialInNumber;
		return this;
	}
	public String getConferenceTemplateName() {
		return conferenceTemplateName;
	}
	public ConferenceRoom setConferenceTemplateName(String conferenceTemplateName) {
		this.conferenceTemplateName = FieldCheckUtils.setField(this, conferenceTemplateName, 50);
		return this;
	}
	public int getMaxParticipants() {
		return maxParticipants;
	}
	public ConferenceRoom setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
		return this;
	}
	public String getMcuPoolOrderName() {
		return mcuPoolOrderName;
	}
	public ConferenceRoom setMcuPoolOrderName(String mcuPoolOrderName) {
		this.mcuPoolOrderName = mcuPoolOrderName;
		return this;
	}
	public String getTerritoryName() {
		return territoryName;
	}
	public ConferenceRoom setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
		return this;
	}
	public boolean isChairpersonRequired() {
		return chairpersonRequired;
	}
	public ConferenceRoom setChairpersonRequired(boolean chairpersonRequired) {
		this.chairpersonRequired = chairpersonRequired;
		return this;
	}
	public String getChairpersonCode() {
		return chairpersonCode;
	}
	public ConferenceRoom setChairpersonCode(String chairpersonCode) {
		this.chairpersonCode = FieldCheckUtils.setField(this, chairpersonCode, 16);
		return this;
	}
	public boolean isChairpersonCodeUseAsAlias() {
		return chairpersonCodeUseAsAlias;
	}
	public ConferenceRoom setChairpersonCodeUseAsAlias(boolean chairpersonCodeUseAsAlias) {
		this.chairpersonCodeUseAsAlias = chairpersonCodeUseAsAlias;
		return this;
	}
	public String getConferenceCode() {
		return conferenceCode;
	}
	public ConferenceRoom setConferenceCode(String conferenceCode) {
		this.conferenceCode = FieldCheckUtils.setField(this, conferenceCode, 16);
		return this;
	}
	public boolean isConferenceCodeUseAsAlias() {
		return conferenceCodeUseAsAlias;
	}
	public ConferenceRoom setConferenceCodeUseAsAlias(boolean conferenceCodeUseAsAlias) {
		this.conferenceCodeUseAsAlias = conferenceCodeUseAsAlias;
		return this;
	}
	public String getEntityTag() {
		return entityTag;
	}
	public ConferenceRoom setEntityTag(String entityTag) {
		this.entityTag = FieldCheckUtils.setField(this, entityTag, 64);
		return this;
	}
	public String getPassback() {
		return passback;
	}
	public ConferenceRoom setPassback(String passback) {
		this.passback = FieldCheckUtils.setField(this, passback, 512);
		return this;
	}
	public String getPassthru() {
		return passthru;
	}
	public ConferenceRoom setPassthru(String passthru) {
		this.passthru = FieldCheckUtils.setField(this, passthru, 512);
		return this;
	}
	public boolean isAutoDialOut() {
		return autoDialOut;
	}
	public ConferenceRoom setAutoDialOut(boolean autoDialOut) {
		this.autoDialOut = autoDialOut;
		return this;
	}
	public String getResourcePriorityNamespace() {
		return resourcePriorityNamespace;
	}
	public ConferenceRoom setResourcePriorityNamespace(String resourcePriorityNamespace) {
		this.resourcePriorityNamespace = FieldCheckUtils.setField(this, resourcePriorityNamespace, 62);
		return this;
	}
	public String getResourcePriorityValue() {
		return resourcePriorityValue;
	}
	public ConferenceRoom setResourcePriorityValue(String resourcePriorityValue) {
		this.resourcePriorityValue = FieldCheckUtils.setField(this, resourcePriorityValue, 64);
		return this;
	}
	public boolean isFirstCallerMcuAffinity() {
		return firstCallerMcuAffinity;
	}
	public ConferenceRoom setFirstCallerMcuAffinity(boolean firstCallerMcuAffinity) {
		this.firstCallerMcuAffinity = firstCallerMcuAffinity;
		return this;
	}
	public boolean isConfRoomPublishable() {
		return confRoomPublishable;
	}
	public ConferenceRoom setConfRoomPublishable(boolean confRoomPublishable) {
		this.confRoomPublishable = confRoomPublishable;
		return this;
	}
	public boolean isOverrideLastDisconnect() {
		return overrideLastDisconnect;
	}
	public ConferenceRoom setOverrideLastDisconnect(boolean overrideLastDisconnect) {
		this.overrideLastDisconnect = overrideLastDisconnect;
		return this;
	}
	public String getFocusUri() {
		return focusUri;
	}
	public ConferenceRoom setFocusUri(String focusUri) {
		this.focusUri = FieldCheckUtils.setField(this, focusUri, 512);
		return this;
	}
	public String getLyncRegisteredDomain() {
		return lyncRegisteredDomain;
	}
	public ConferenceRoom setLyncRegisteredDomain(String lyncRegisteredDomain) {
		this.lyncRegisteredDomain = FieldCheckUtils.setField(this, lyncRegisteredDomain, 128);
		return this;
	}
	public LocalDateTime getNotBefore() {
		return notBefore;
	}
	public ConferenceRoom setNotBefore(LocalDateTime notBefore) {
		this.notBefore = notBefore;
		return this;
	}
	public LocalDateTime getNotAfter() {
		return notAfter;
	}
	public ConferenceRoom setNotAfter(LocalDateTime notAfter) {
		this.notAfter = notAfter;
		return this;
	}
	
	
}
