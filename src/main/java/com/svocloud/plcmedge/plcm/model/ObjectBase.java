package com.svocloud.plcmedge.plcm.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectBase {
	
	protected List<Link> atomLinkList = new ArrayList<Link>();

	public List<Link> getAtomLinkList() {
		return atomLinkList;
	}

	public void setAtomLinkList(List<Link> atomLinkList) {
		this.atomLinkList = atomLinkList;
	}
	
}
