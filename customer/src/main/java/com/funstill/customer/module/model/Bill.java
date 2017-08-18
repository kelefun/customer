package com.funstill.customer.module.model;

import java.util.Date;

import com.funstill.customer.base.model.BaseModel;

/**
 * 
 * @author liukaiyang 2017年8月15日
 */
public class Bill extends BaseModel{
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	
	/**
	 * 商品价格--单价
	 */
	private Double goodsPrice;
	
	/**
	 * 商品数量
	 */
	private Integer goodsNumber;
	
	
	/**
	 * 账单备注说明
	 */
	private String extra;
	
	/**
	 * 应付款
	 */
	private Double payable;
	
	/**
	 * 已收款
	 */
	private Double received;
	
	
	/**
	 * 付款方式
	 */
	private Integer payForm ;
	
	/**
	 * 账单创建日期
	 */
	private Date createDate;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Double getPayable() {
		return payable;
	}

	public void setPayable(Double payable) {
		this.payable = payable;
	}

	public Double getReceived() {
		return received;
	}

	public void setReceived(Double received) {
		this.received = received;
	}

	public Integer getPayForm() {
		return payForm;
	}

	public void setPayForm(Integer payForm) {
		this.payForm = payForm;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
