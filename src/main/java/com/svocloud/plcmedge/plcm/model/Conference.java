package com.svocloud.plcmedge.plcm.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.svocloud.plcmedge.enums.LayoutEnum;
import com.svocloud.plcmedge.utils.StringUtils;

public class Conference {
	
	/** 会议uuid*/
	private String uuid;
	
	private String dialInNumber;
	
	/** 会议室(room)id*/
	private String roomId;
	
	/** 会议id*/
	private String id;
	
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
	
	private final static int ID_MAX_VALUE=128;
	/*private final static int CURRENTLAYOUT_MAX_VALUE=128;
	private final static int SUPPORTEDLAYOUT_MAX_VALUE=128;*/
	private final static int ENTITYTAG_MAX_VALUE=64;
	private final static int PASSTHRU_MAX_VALUE=512;
	private final static int PASSBACK_MAX_VALUE=512;
	private final static int HOSTNAME_MAX_VALUE=128;
	private final static int OWNERLASTNAME_MAX_VALUE=64;
	private final static int OWNERFIRSTNAME_MAX_VALUE=64;
	private final static int CASCADEMCUNAME_MAX_VALUE=128;
	private final static int MCUNAME_MAX_VALUE=128;
	private final static int ROOMID_MAX_VALUE=128;
	private final static int DIALINNUMBER_MAX_VALUE=128;
	private final static int MIN_VALUE=1;
	
	public String getUuid() {
		return uuid;
	}
	public Conference setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	public String getDialInNumber() {
		return dialInNumber;
	}
	public Conference setDialInNumber(String dialInNumber) {
		if(StringUtils.isEmpty(dialInNumber)){
			throw new RuntimeException("会议dialInNumber不能为空");
		}
		if(dialInNumber.length()>DIALINNUMBER_MAX_VALUE||dialInNumber.length()<MIN_VALUE){
			throw new RuntimeException("会议dialInNumber长度不合法");
		}
		this.dialInNumber = dialInNumber;
		return this;
	}
	public String getRoomId() {
		return roomId;
	}
	public Conference setRoomId(String roomId) {
		if(StringUtils.isEmpty(roomId)){
			throw new RuntimeException("会议roomId不能为空");
		}
		if(roomId.length()>ROOMID_MAX_VALUE||roomId.length()<MIN_VALUE){
			throw new RuntimeException("会议roomId长度不合法");
		}
		this.roomId = roomId;
		return this;
	}
	public String getId() {
		return id;
	}
	public Conference setId(String id) {
		if(StringUtils.isEmpty(id)){
			throw  new RuntimeException("会议id不能为空");
		}
		if(id.length()>ID_MAX_VALUE||id.length()<MIN_VALUE){
			throw  new RuntimeException("会议id长度不合法");
		}
		this.id = id;
		return this;
	}
	public String getMcuName() {
		return mcuName;
	}
	public Conference setMcuName(String mcuName) {
		if(StringUtils.isEmpty(mcuName)){
			throw new RuntimeException("会议mcuName不能为空");
		}
		if(mcuName.length()>MCUNAME_MAX_VALUE||mcuName.length()<MIN_VALUE){
			throw new RuntimeException("会议mcuName长度不合法");
		}
		this.mcuName = mcuName;
		return this;
	}
	public String getCascadeMcuName() {
		return cascadeMcuName;
	}
	public Conference setCascadeMcuName(String cascadeMcuName) {
		if(StringUtils.isEmpty(cascadeMcuName)){
			throw new RuntimeException("会议cascadeMcuName不能为空");
		}
		if(cascadeMcuName.length()>CASCADEMCUNAME_MAX_VALUE||cascadeMcuName.length()<MIN_VALUE){
			throw new RuntimeException("会议cascadeMcuName长度不合法");
		}
		this.cascadeMcuName = cascadeMcuName;
		return this;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public Conference setOwnerFirstName(String ownerFirstName) {
		if(StringUtils.isEmpty(cascadeMcuName)){
			throw new RuntimeException("会议ownerFirstName不能为空");
		}
		if(ownerFirstName.length()>OWNERFIRSTNAME_MAX_VALUE||ownerFirstName.length()<MIN_VALUE){
			throw new RuntimeException("会议ownerFirstName长度不合法");
		}
		this.ownerFirstName = ownerFirstName;
		return this;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public Conference setOwnerLastName(String ownerLastName) {
		if(StringUtils.isEmpty(ownerLastName)){
			throw new RuntimeException("会议ownerLastName不能为空");
		}
		if(ownerLastName.length()>OWNERLASTNAME_MAX_VALUE||ownerLastName.length()<MIN_VALUE){
			throw new RuntimeException("会议ownerLastName长度不合法");
		}
		this.ownerLastName = ownerLastName;
		return this;
	}
	public String getHostName() {
		return hostName;
	}
	public Conference setHostName(String hostName) {
		if(StringUtils.isEmpty(hostName)){
			throw new RuntimeException("会议hostName不能为空");
		}
		if(hostName.length()>HOSTNAME_MAX_VALUE||hostName.length()<MIN_VALUE){
			throw new RuntimeException("会议hostName长度不合法");
		}
		this.hostName = hostName;
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
		if(passBack.length()>PASSBACK_MAX_VALUE||passBack.length()<MIN_VALUE){
			throw new RuntimeException("会议passBack长度不合法");
		}
		this.passBack = passBack;
		return this;
	}
	public String getPassThru() {
		return passThru;
	}
	public Conference setPassThru(String passThru) {
		if(passThru.length()>PASSTHRU_MAX_VALUE||passThru.length()<MIN_VALUE){
			throw new RuntimeException("会议passThru长度不合法");
		}
		this.passThru = passThru;
		return this;
	}
	public String getEntityTag() {
		return entityTag;
	}
	public Conference setEntityTag(String entityTag) {
		if(entityTag.length()>ENTITYTAG_MAX_VALUE||entityTag.length()<MIN_VALUE){
			throw new RuntimeException("会议entityTag长度不合法");
		}
		this.entityTag = entityTag;
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
		if(startTime==null){
			throw new RuntimeException("会议开始时间不能为空");
		}
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
		this.currentLayout = currentLayout;
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
		return "Conference [uuid=" + uuid + ", dialInNumber=" + dialInNumber + ", roomId=" + roomId + ", id=" + id
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
