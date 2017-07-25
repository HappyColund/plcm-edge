package com.svocloud.plcmedge.commons;

import com.svocloud.plcmedge.enums.ResultEnum;

public class Result {
	
	private Result result=null;
	private int code;
	private String message;
	private Object data;
	
	private Result(){}
	
	public  Result result(ResultEnum resultEnum,Object data){
		result = new Result();
		result.setCode(resultEnum.getCode());
		result.setMessage(resultEnum.getMsg());
		result.setData(data);
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
