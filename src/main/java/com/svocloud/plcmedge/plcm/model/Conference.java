package com.svocloud.plcmedge.plcm.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.svocloud.plcmedge.enums.LayoutEnum;
import com.svocloud.plcmedge.utils.FieldSetUtils;
import com.svocloud.plcmedge.utils.StringUtils;

public class Conference {
	
	/** 会议uuid*/
	private String uuid;
	
	private String dialInNumber;
	
	/** 会议室(room)id*/
	private String conferenceRoomIdentifier;
	
	/** 会议id*/
	private String conferenceIdentifier;
	
	/** 会议所在mcu名字*/
	private String mcuName;
	
	/** hosting mcu(若该会议是级联会议)*/
	private String cascadeMcuName;
	
	/** 会议主持人的firstName*/
	private String ownerFirstName;
	
	/** 会议主持人的lastName*/
	private String ownerLastName;
	
	/** 会议主机的主机名*/
	private String hostName;
	
	/** 是否在录制*/
	private boolean recordingActive;
	
	/** 会议的显示文字*/
	private String displayText;
	
	private String passBack;
	
	private String passThru;
	
	/** HTTP Entity Tag (ETag) header */
	private String entityTag;
	
	/** 支持的分屏模板*/
	private List<LayoutEnum> supportedLayouts = new ArrayList<LayoutEnum>();
	
	/** 目前应用的模板*/
	private LayoutEnum currentLayout;
	
	/** 该会议是否已锁定*/
	private boolean isLocked;
	
	/** 新入会人员是否静音*/
	private boolean joinNewCallsMuted;
	
	/** focusUri*/
	private String focusUri;
	
	/** 呼叫次数*/
	private short callCount;
	
	/** 会议开始时间*/
	private LocalDateTime startTime;
	/** 会议结束时间*/
	private LocalDateTime endTime;
	
	private List<PlcmCascadeLink> plcmCascadeLinkList = new ArrayList<PlcmCascadeLink>();
	
	private List<Link> atomLinkList = new ArrayList<Link>();
	
	private PlcmInternalParams plcmInternalParams;
	
	public String getUuid() {
		return uuid;
	}
	public Conference setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	
	public String getConferenceIdentifier() {
		return conferenceIdentifier;
	}
	public Conference setConferenceIdentifier(String conferenceIdentifier) {
		this.conferenceIdentifier = FieldSetUtils.setField(this, conferenceIdentifier, 128);
		return this;
	}
	public String getDialInNumber() {
		return dialInNumber;
	}
	public Conference setDialInNumber(String dialInNumber) {
		this.dialInNumber = FieldSetUtils.setField(this, dialInNumber, 128);
		return this;
	}
	
	public String getConferenceRoomIdentifier() {
		return conferenceRoomIdentifier;
	}
	public Conference setConferenceRoomIdentifier(String conferenceRoomIdentifier) {
		this.conferenceRoomIdentifier = FieldSetUtils.setField(this, conferenceRoomIdentifier, 128);
		return this;
	}
	public String getMcuName() {
		return mcuName;
	}
	public Conference setMcuName(String mcuName) {
		this.mcuName = FieldSetUtils.setField(this, mcuName, 0);
		return this;
	}
	public String getCascadeMcuName() {
		return cascadeMcuName;
	}
	public Conference setCascadeMcuName(String cascadeMcuName) {
		this.cascadeMcuName = FieldSetUtils.setField(this, cascadeMcuName, 128);
		return this;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public Conference setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = FieldSetUtils.setField(this, ownerFirstName, 64);
		return this;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public Conference setOwnerLastName(String ownerLastName) {
		this.ownerLastName = FieldSetUtils.setField(this, ownerLastName, 64);
		return this;
	}
	public String getHostName() {
		return hostName;
	}
	public Conference setHostName(String hostName) {
		this.hostName = FieldSetUtils.setField(this, hostName, 128);
		return this;
	}
	public boolean isRecordingActive() {
		return recordingActive;
	}
	public Conference setRecordingActive(boolean recordingActive) {
		this.recordingActive = recordingActive;
		return this;
	}
	public String getDisplayText() {
		return displayText;
	}
	public Conference setDisplayText(String displayText) {
		this.displayText = displayText;
		return this;
	}
	public String getPassBack() {
		return passBack;
	}
	public Conference setPassBack(String passBack) {
		this.passBack = FieldSetUtils.setField(this, passBack, 512);
		return this;
	}
	public String getPassThru() {
		return passThru;
	}
	public Conference setPassThru(String passThru) {
		this.passThru = FieldSetUtils.setField(this, passThru, 512);
		return this;
	}
	public String getEntityTag() {
		return entityTag;
	}
	public Conference setEntityTag(String entityTag) {
		this.entityTag = FieldSetUtils.setField(this, entityTag, 512);
		return this;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public Conference setLocked(boolean isLocked) {
		this.isLocked = isLocked;
		return this;
	}
	public boolean isJoinNewCallsMuted() {
		return joinNewCallsMuted;
	}
	public Conference setJoinNewCallsMuted(boolean joinNewCallsMuted) {
		this.joinNewCallsMuted = joinNewCallsMuted;
		return this;
	}
	public String getFocusUri() {
		return focusUri;
	}
	public Conference setFocusUri(String focusUri) {
		this.focusUri = focusUri;
		return this;
	}
	public short getCallCount() {
		return callCount;
	}
	public Conference setCallCount(short callCount) {
		this.callCount = callCount;
		return this;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public Conference setStartTime(LocalDateTime startTime) {
		if(startTime==null) throw new RuntimeException("Conference对象中：startTime属性不能设置为空");
		this.startTime = startTime;
		return this;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public Conference setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
		return this;
	}
	public List<LayoutEnum> getSupportedLayouts() {
		return supportedLayouts;
	}
	public Conference setSupportedLayouts(List<LayoutEnum> supportedLayouts) {
		this.supportedLayouts = supportedLayouts;
		return this;
	}
	public LayoutEnum getCurrentLayout() {
		return currentLayout;
	}
	public Conference setCurrentLayout(LayoutEnum currentLayout) {
		return this;
	}
	public List<PlcmCascadeLink> getPlcmCascadeLinkList() {
		return plcmCascadeLinkList;
	}
	public Conference setPlcmCascadeLinkList(List<PlcmCascadeLink> plcmCascadeLinkList) {
		this.plcmCascadeLinkList = plcmCascadeLinkList;
		return this;
	}
	public List<Link> getAtomLinkList() {
		return atomLinkList;
	}
	public Conference setAtomLinkList(List<Link> atomLinkList) {
		this.atomLinkList = atomLinkList;
		return this;
	}
	public PlcmInternalParams getPlcmInternalParams() {
		return plcmInternalParams;
	}
	public Conference setPlcmInternalParams(PlcmInternalParams plcmInternalParams) {
		this.plcmInternalParams = plcmInternalParams;
		return this;
	}
	@Override
	public String toString() {
		return "Conference [uuid=" + uuid + ", dialInNumber=" + dialInNumber + ", roomId=" + roomId + ", conferenceIdentifier=" + conferenceIdentifier
				+ ", mcuName=" + mcuName + ", cascadeMcuName=" + cascadeMcuName + ", ownerFirstName=" + ownerFirstName
				+ ", ownerLastName=" + ownerLastName + ", hostName=" + hostName + ", recordingActive=" + recordingActive
				+ ", displayText=" + displayText + ", passBack=" + passBack + ", passThru=" + passThru + ", entityTag="
				+ entityTag + ", supportedLayouts=" + supportedLayouts + ", currentLayout=" + currentLayout
				+ ", isLocked=" + isLocked + ", joinNewCallsMuted=" + joinNewCallsMuted + ", focusUri=" + focusUri
				+ ", callCount=" + callCount + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", plcmCascadeLinkList=" + plcmCascadeLinkList + ", atomLinkList=" + atomLinkList
				+ ", plcmInternalParams=" + plcmInternalParams + "]";
	}
	
}
