package com.svocloud.plcmedge.plcm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlcmError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int statusCode;
	private String description;
	private String technicalDetails;
	private int detailedErrorCode;
	private String localizationKey;
	private List<String> localizationParam = new ArrayList<String>();
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnicalDetails() {
		return technicalDetails;
	}
	public void setTechnicalDetails(String technicalDetails) {
		this.technicalDetails = technicalDetails;
	}
	public int getDetailedErrorCode() {
		return detailedErrorCode;
	}
	public void setDetailedErrorCode(int detailedErrorCode) {
		this.detailedErrorCode = detailedErrorCode;
	}
	public String getLocalizationKey() {
		return localizationKey;
	}
	public void setLocalizationKey(String localizationKey) {
		this.localizationKey = localizationKey;
	}
	public List<String> getLocalizationParam() {
		return localizationParam;
	}
	public void setLocalizationParam(List<String> localizationParam) {
		this.localizationParam = localizationParam;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
