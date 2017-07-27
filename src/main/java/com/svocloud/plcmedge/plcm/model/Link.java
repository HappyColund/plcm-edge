package com.svocloud.plcmedge.plcm.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.svocloud.plcmedge.utils.StringUtils;

public class Link {

	private String href;
	private String rel;
	private String type;
	private String hreflang;
	private String title;
	private String length;
	
	
	public String getHref() {
		return href;
	}
	public Link setHref(String href) {
		if(StringUtils.isEmpty(href)) throw new RuntimeException("Link实体： href属性不能为空");
		this.href = href;
		return this;
	}
	public String getRel() {
		return rel;
	}
	public Link setRel(String rel) {
		this.rel = rel;
		return this;
	}
	public String getType() {
		return type;
	}
	public Link setType(String type) {
		Matcher matcher = Pattern.compile(".+//.+").matcher(type);
		if(!matcher.matches()) throw new RuntimeException("Link实体： type属性不符合正则表达式");
		this.type = type;
		return this;
	}
	public String getHreflang() {
		return hreflang;
	}
	public Link setHreflang(String hreflang) {
		Matcher matcher = Pattern.compile("[A-Za-z]{1,8}(-[A-Za-z0-9]{1,8})*").matcher(hreflang);
		if(!matcher.matches()) throw new RuntimeException("Link实体： hreflang属性不符合正则表达式");
		this.hreflang = hreflang;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Link setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getLength() {
		return length;
	}
	public Link setLength(String length) {
		this.length = length;
		return this;
	}
	@Override
	public String toString() {
		return "Link [href=" + href + ", rel=" + rel + ", type=" + type + ", hreflang=" + hreflang + ", title=" + title
				+ ", length=" + length + "]";
	}
	
	
}
