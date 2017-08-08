package com.svocloud.plcmedge.enums;

public enum ResultEnum {
	
	SUCCESS(200,"Success",200),
	BAD_REQUEST(400, "Bad Request",400),
	NOT_FOUND(404,"Not Found",404),
	INTERNAL_ERROR(503,"Service Unavailable",503),
	PARAMNOTFOUNT(400, "Missing Necessary Parameter", 400);
	
	private int code;
	private String msg;
	private int httpStatusCode;
	private ResultEnum(int code, String msg,int httpStatusCode) {
		this.code = code;
		this.msg = msg;
		this.httpStatusCode=httpStatusCode;
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
	public int getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
}
