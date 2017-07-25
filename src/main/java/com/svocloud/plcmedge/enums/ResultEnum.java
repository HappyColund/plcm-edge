package com.svocloud.plcmedge.enums;

public enum ResultEnum {
	
	SUCCESS(200,"Success"),
	BAD_REQUEST(400, "Bad Request"),
	NOT_FOUND(404,"Not Found"),
	INTERNAL_ERROR(503,"Service Unavailable");
	
	private int code;
	private String msg;
	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
