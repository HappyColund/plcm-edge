package com.svocloud.plcmedge.plcm.model;

import java.io.Serializable;

public class PlcmMcuCapacity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mcuCardType;
	
	private short totalAudioPorts;
	
	private short totalVideoPorts;

	public String getMcuCardType() {
		return mcuCardType;
	}

	public void setMcuCardType(String mcuCardType) {
		this.mcuCardType = mcuCardType;
	}

	public short getTotalAudioPorts() {
		return totalAudioPorts;
	}

	public void setTotalAudioPorts(short totalAudioPorts) {
		this.totalAudioPorts = totalAudioPorts;
	}

	public short getTotalVideoPorts() {
		return totalVideoPorts;
	}

	public void setTotalVideoPorts(short totalVideoPorts) {
		this.totalVideoPorts = totalVideoPorts;
	}

	@Override
	public String toString() {
		return "PlcmMcuCapacity [mcuCardType=" + mcuCardType + ", totalAudioPorts=" + totalAudioPorts
				+ ", totalVideoPorts=" + totalVideoPorts + "]";
	}
	
	
}
