package com.svocloud.plcmedge.plcm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class PlcmMcuList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("plcmMcuCapacityList")
	private List<PlcmMcuCapacity> plcmMcuCapacityList = new ArrayList<PlcmMcuCapacity>();
	
	@JsonProperty("plcmMcuList")
	private List<PlcmMcu> plcmMcuList = new ArrayList<PlcmMcu>();

	public List<PlcmMcuCapacity> getPlcmMcuCapacityList() {
		return plcmMcuCapacityList;
	}

	public void setPlcmMcuCapacityList(List<PlcmMcuCapacity> plcmMcuCapacityList) {
		this.plcmMcuCapacityList = plcmMcuCapacityList;
	}

	public List<PlcmMcu> getPlcmMcuList() {
		return plcmMcuList;
	}

	public void setPlcmMcuList(List<PlcmMcu> plcmMcuList) {
		this.plcmMcuList = plcmMcuList;
	}

	@Override
	public String toString() {
		return "PlcmMcuList [plcmMcuCapacityList=" + plcmMcuCapacityList + ", plcmMcuList=" + plcmMcuList + "]";
	}
	
	
}
