package com.svocloud.plcmedge.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.svocloud.plcmedge.enums.ResultEnum;

public class Result {
	
	private Integer code;
	private String msg;
	private Object data;
	@JSONField(serialize = false)
	private Integer httpStatus;



	public Result() {
		this.code = ResultEnum.SUCCESS.getCode();
		this.msg = ResultEnum.SUCCESS.getMsg();
		this.httpStatus = ResultEnum.SUCCESS.getHttpStatusCode();
		this.data = new Object();
	}

	public Result(Object object) {
		this.code = ResultEnum.SUCCESS.getCode();
		this.msg = ResultEnum.SUCCESS.getMsg();
		this.httpStatus = ResultEnum.SUCCESS.getHttpStatusCode();
		System.out.println(JSON.toJSONString(object));
		this.data = object;
	}

	public Result(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.httpStatus = resultEnum.getHttpStatusCode();
		this.data = new Object();
	}

	public Result(ResultEnum resultEnum, Object object) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.httpStatus = resultEnum.getHttpStatusCode();
		this.data = object;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}
	
}
