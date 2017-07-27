package com.svocloud.plcmedge.plcm.model;

import com.svocloud.plcmedge.utils.StringUtils;

public class PlcmDialOutParticipant {
	
	private String name;
	private String dtmfSuffix;
	private boolean audioOnly;
	private String resourcePriorityNamespace;
	private String resourcePriorityValue;
	private String passback;
	private String passthru;
	private String forwardDtmfSource;
	private boolean encryptedMedia;
	private boolean autoDisconnect;
	private String callBitRate;
	private String dialString;
	private PlcmItuPhoneNumber plcmItuPhoneNumber;
	
	private static final int FORWARDDTMFSOURCE_MAX_VALUE=128;
	private static final int PASSTHRU_MAX_VALUE=512;
	private static final int PASSBACK_MAX_VALUE=512;
	private static final int RESOURCEPRIORITYVALUE_MAX_VALUE=64;
	private static final int RESOURCEPRIORITYNAMESPACE_MAX_VALUE=64;
	private static final int DTMFSUFFIX_MAX_VALUE=64;
	private static final int MIN_VALUE=64;
	
	public String getName() {
		return name;
	}
	public PlcmDialOutParticipant setName(String name) {
		this.name = name;
		return this;
	}
	public String getDtmfSuffix() {
		return dtmfSuffix;
	}
	public PlcmDialOutParticipant setDtmfSuffix(String dtmfSuffix) {
		if(dtmfSuffix.length()<MIN_VALUE||dtmfSuffix.length()>DTMFSUFFIX_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:dtmfSuffix属性不符合要求");
		this.dtmfSuffix = dtmfSuffix;
		return this;
	}
	public boolean isAudioOnly() {
		return audioOnly;
	}
	public PlcmDialOutParticipant setAudioOnly(boolean audioOnly) {
		this.audioOnly = audioOnly;
		return this;
	}
	public String getResourcePriorityNamespace() {
		return resourcePriorityNamespace;
	}
	public PlcmDialOutParticipant setResourcePriorityNamespace(String resourcePriorityNamespace) {
		if(resourcePriorityNamespace.length()<MIN_VALUE||resourcePriorityNamespace.length()>RESOURCEPRIORITYNAMESPACE_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:resourcePriorityNamespace属性不符合要求");
		this.resourcePriorityNamespace = resourcePriorityNamespace;
		return this;
	}
	public String getResourcePriorityValue() {
		return resourcePriorityValue;
	}
	public PlcmDialOutParticipant setResourcePriorityValue(String resourcePriorityValue) {
		if(resourcePriorityValue.length()<MIN_VALUE||resourcePriorityValue.length()>RESOURCEPRIORITYVALUE_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:resourcePriorityValue属性不符合要求");
		this.resourcePriorityValue = resourcePriorityValue;
		return this;
	}
	public String getPassback() {
		return passback;
	}
	public PlcmDialOutParticipant setPassback(String passback) {
		if(passback.length()<MIN_VALUE||passback.length()>PASSBACK_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:passback属性不符合要求");
		this.passback = passback;
		return this;
	}
	public String getPassthru() {
		return passthru;
	}
	public PlcmDialOutParticipant setPassthru(String passthru) {
		if(passthru.length()<MIN_VALUE||passthru.length()>PASSTHRU_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:passthru属性不符合要求");
		this.passthru = passthru;
		return this;
	}
	public String getForwardDtmfSource() {
		return forwardDtmfSource;
	}
	public PlcmDialOutParticipant setForwardDtmfSource(String forwardDtmfSource) {
		if(forwardDtmfSource.length()<MIN_VALUE||forwardDtmfSource.length()>FORWARDDTMFSOURCE_MAX_VALUE) 
			throw new RuntimeException("PlcmDialOutParticipant对象:forwardDtmfSource属性不符合要求");
		this.forwardDtmfSource = forwardDtmfSource;
		return this;
	}
	public boolean isEncryptedMedia() {
		return encryptedMedia;
	}
	public PlcmDialOutParticipant setEncryptedMedia(boolean encryptedMedia) {
		this.encryptedMedia = encryptedMedia;
		return this;
	}
	public boolean isAutoDisconnect() {
		return autoDisconnect;
	}
	public PlcmDialOutParticipant setAutoDisconnect(boolean autoDisconnect) {
		this.autoDisconnect = autoDisconnect;
		return this;
	}
	public String getCallBitRate() {
		return callBitRate;
	}
	public PlcmDialOutParticipant setCallBitRate(String callBitRate) {
		this.callBitRate = callBitRate;
		return this;
	}
	public String getDialString() {
		return dialString;
	}
	public PlcmDialOutParticipant setDialString(String dialString) {
		if(StringUtils.isEmpty(dialString)) throw new RuntimeException("PlcmDialOutParticipant对象:dialString属性不能为空");
		this.dialString = dialString;
		return this;
	}
	public PlcmItuPhoneNumber getPlcmItuPhoneNumber() {
		return plcmItuPhoneNumber;
	}
	public PlcmDialOutParticipant setPlcmItuPhoneNumber(PlcmItuPhoneNumber plcmItuPhoneNumber) {
		if(plcmItuPhoneNumber==null) throw new RuntimeException("PlcmDialOutParticipant对象:plcmItuPhoneNumber属性不能为空");
		this.plcmItuPhoneNumber = plcmItuPhoneNumber;
		return this;
	}
	
	
}
