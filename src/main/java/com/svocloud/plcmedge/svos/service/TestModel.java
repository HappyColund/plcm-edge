package com.svocloud.plcmedge.svos.service;

import java.math.BigDecimal;
import java.util.Date;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class TestModel {
	
	private Integer id;
	private String modeName;
	private Date createDate;
	private BigDecimal price;
	
	
	public TestModel() {
		super();
	}

	public TestModel(Integer id, String modeName, Date createDate, BigDecimal price) {
		super();
		this.id = id;
		this.modeName = modeName;
		this.createDate = createDate;
		this.price = price;
	}

	public TestModel(JsonObject json) {
		TestModelConverter.fromJson(json, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		TestModelConverter.toJson(this, json);
		return json;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "TestModel [id=" + id + ", modeName=" + modeName + ", createDate=" + createDate + ", price=" + price
				+ "]";
	}
	
}
