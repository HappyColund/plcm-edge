package com.svocloud.plcmedge.plcm.model;

import java.util.ArrayList;
import java.util.List;

import com.svocloud.plcmedge.utils.StringUtils;

public class PlcmCascadeLink {
	
	private List<Link> atomLinkList = new ArrayList<Link>();
	private String cascadeLinkIdentifier;
	private String name;
	private String fromMcuName;
	private String toMcuName;
	
	public List<Link> getAtomLinkList() {
		return atomLinkList;
	}
	public PlcmCascadeLink setAtomLinkList(List<Link> atomLinkList) {
		this.atomLinkList = atomLinkList;
		return this;
	}
	public String getCascadeLinkIdentifier() {
		return cascadeLinkIdentifier;
	}
	public PlcmCascadeLink setCascadeLinkIdentifier(String cascadeLinkIdentifier) {
		if(StringUtils.isEmpty(cascadeLinkIdentifier)) throw new RuntimeException("PlcmCascadeLink实体中cascadeLinkIdentifier属性不能为空");
		this.cascadeLinkIdentifier = cascadeLinkIdentifier;
		return this;
	}
	public String getName() {
		return name;
	}
	public PlcmCascadeLink setName(String name) {
		this.name = name;
		return this;
	}
	public String getFromMcuName() {
		return fromMcuName;
	}
	public PlcmCascadeLink setFromMcuName(String fromMcuName) {
		this.fromMcuName = fromMcuName;
		return this;
	}
	public String getToMcuName() {
		return toMcuName;
	}
	public PlcmCascadeLink setToMcuName(String toMcuName) {
		this.toMcuName = toMcuName;
		return this;
	}
	@Override
	public String toString() {
		return "PlcmCascadeLink [atomLinkList=" + atomLinkList + ", cascadeLinkIdentifier=" + cascadeLinkIdentifier
				+ ", name=" + name + ", fromMcuName=" + fromMcuName + ", toMcuName=" + toMcuName + "]";
	}
	
	
}
