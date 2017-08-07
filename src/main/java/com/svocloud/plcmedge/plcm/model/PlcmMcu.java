package com.svocloud.plcmedge.plcm.model;

import java.io.Serializable;

public class PlcmMcu extends ObjectBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7507871284245453208L;
	
	private String plcmMcuCapacity;
	private String mcuIdentifier;
	private String name;
	private String managementIp;
	private String mcuType;
	private boolean overlap;
	private short reservedAudioPorts;
	private short reservedVideoPorts;
	private short dmaAudioPorts;
	private short dmaVideoPorts;
	private short dmaUsedAudioPorts;
	private short dmaUsedVideoPorts;
	private short totalUsedAudioPorts;
	private short totalUsedVideoPorts;
	private short maxBitRate;
	private boolean supportsSVC;
	private String passback;
	private String entityTag;
	public String getPlcmMcuCapacity() {
		return plcmMcuCapacity;
	}
	public void setPlcmMcuCapacity(String plcmMcuCapacity) {
		this.plcmMcuCapacity = plcmMcuCapacity;
	}
	public String getMcuIdentifier() {
		return mcuIdentifier;
	}
	public void setMcuIdentifier(String mcuIdentifier) {
		this.mcuIdentifier = mcuIdentifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagementIp() {
		return managementIp;
	}
	public void setManagementIp(String managementIp) {
		this.managementIp = managementIp;
	}
	public String getMcuType() {
		return mcuType;
	}
	public void setMcuType(String mcuType) {
		this.mcuType = mcuType;
	}
	public boolean isOverlap() {
		return overlap;
	}
	public void setOverlap(boolean overlap) {
		this.overlap = overlap;
	}
	public short getReservedAudioPorts() {
		return reservedAudioPorts;
	}
	public void setReservedAudioPorts(short reservedAudioPorts) {
		this.reservedAudioPorts = reservedAudioPorts;
	}
	public short getReservedVideoPorts() {
		return reservedVideoPorts;
	}
	public void setReservedVideoPorts(short reservedVideoPorts) {
		this.reservedVideoPorts = reservedVideoPorts;
	}
	public short getDmaAudioPorts() {
		return dmaAudioPorts;
	}
	public void setDmaAudioPorts(short dmaAudioPorts) {
		this.dmaAudioPorts = dmaAudioPorts;
	}
	public short getDmaVideoPorts() {
		return dmaVideoPorts;
	}
	public void setDmaVideoPorts(short dmaVideoPorts) {
		this.dmaVideoPorts = dmaVideoPorts;
	}
	public short getDmaUsedAudioPorts() {
		return dmaUsedAudioPorts;
	}
	public void setDmaUsedAudioPorts(short dmaUsedAudioPorts) {
		this.dmaUsedAudioPorts = dmaUsedAudioPorts;
	}
	public short getDmaUsedVideoPorts() {
		return dmaUsedVideoPorts;
	}
	public void setDmaUsedVideoPorts(short dmaUsedVideoPorts) {
		this.dmaUsedVideoPorts = dmaUsedVideoPorts;
	}
	public short getTotalUsedAudioPorts() {
		return totalUsedAudioPorts;
	}
	public void setTotalUsedAudioPorts(short totalUsedAudioPorts) {
		this.totalUsedAudioPorts = totalUsedAudioPorts;
	}
	public short getTotalUsedVideoPorts() {
		return totalUsedVideoPorts;
	}
	public void setTotalUsedVideoPorts(short totalUsedVideoPorts) {
		this.totalUsedVideoPorts = totalUsedVideoPorts;
	}
	public short getMaxBitRate() {
		return maxBitRate;
	}
	public void setMaxBitRate(short maxBitRate) {
		this.maxBitRate = maxBitRate;
	}
	public boolean isSupportsSVC() {
		return supportsSVC;
	}
	public void setSupportsSVC(boolean supportsSVC) {
		this.supportsSVC = supportsSVC;
	}
	public String getPassback() {
		return passback;
	}
	public void setPassback(String passback) {
		this.passback = passback;
	}
	public String getEntityTag() {
		return entityTag;
	}
	public void setEntityTag(String entityTag) {
		this.entityTag = entityTag;
	}
	@Override
	public String toString() {
		return "PlcmMcu [plcmMcuCapacity=" + plcmMcuCapacity + ", mcuIdentifier=" + mcuIdentifier + ", name=" + name
				+ ", managementIp=" + managementIp + ", mcuType=" + mcuType + ", overlap=" + overlap
				+ ", reservedAudioPorts=" + reservedAudioPorts + ", reservedVideoPorts=" + reservedVideoPorts
				+ ", dmaAudioPorts=" + dmaAudioPorts + ", dmaVideoPorts=" + dmaVideoPorts + ", dmaUsedAudioPorts="
				+ dmaUsedAudioPorts + ", dmaUsedVideoPorts=" + dmaUsedVideoPorts + ", totalUsedAudioPorts="
				+ totalUsedAudioPorts + ", totalUsedVideoPorts=" + totalUsedVideoPorts + ", maxBitRate=" + maxBitRate
				+ ", supportsSVC=" + supportsSVC + ", passback=" + passback + ", entityTag=" + entityTag + "]";
	}
	
	
	
}
