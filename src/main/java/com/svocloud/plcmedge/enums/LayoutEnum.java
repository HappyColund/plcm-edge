
package com.svocloud.plcmedge.enums;

/**
 * polycom 支持的分屏类型：
 *
 */
public enum LayoutEnum {
	
	ONE_PLUS_TWO_BOTTOM(100,"1 plus 2 bottom ");
	
	private int code;
	private String description;
	
	
	private LayoutEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
