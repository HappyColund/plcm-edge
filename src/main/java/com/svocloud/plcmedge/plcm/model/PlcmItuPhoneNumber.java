package com.svocloud.plcmedge.plcm.model;

import com.svocloud.plcmedge.utils.StringUtils;

public class PlcmItuPhoneNumber {
	
	private String subscriberNum;
	
	private String nationalDestCode;
	
	private String countryCode;
	
	public String getSubscriberNum() {
		return subscriberNum;
	}
	public PlcmItuPhoneNumber setSubscriberNum(String subscriberNum) {
		if(StringUtils.isEmpty(subscriberNum)) throw new RuntimeException("PlcmItuPhoneNumber对象中：PlcmItuPhoneNumber属性不能为空");
		this.subscriberNum = subscriberNum;
		return this;
	}
	public String getNationalDestCode() {
		return nationalDestCode;
	}
	public PlcmItuPhoneNumber setNationalDestCode(String nationalDestCode) {
		this.nationalDestCode = nationalDestCode;
		return this;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public PlcmItuPhoneNumber setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}
	
}
