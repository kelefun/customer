package com.funstill.customer.module.model;

import com.funstill.customer.base.model.BaseModel;

public class Goods extends BaseModel{
	
	/**
	 * 商品名称
	 */
	private String name;
	
	
	/**
	 * 商品价格--单价
	 */
	private Double price;
	
	/**
	 * 商品库存
	 */
	private Integer inventory;
	

	/**
	 * 商品单位名称--比如箱,瓶,个等
	 */
	private String unit;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getInventory() {
		return inventory;
	}


	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}
}
