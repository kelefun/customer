package com.funstill.customer.module.model;

import java.util.Date;

import com.funstill.customer.base.model.BaseModel;

/**
 * 
 * @author liukaiyang 2017年8月15日
 */
public class Bill extends BaseModel {
	private Goods goods;

	/**
	 * 账单备注说明
	 */
	private String extra;

	/**
	 * 应付款
	 */
	private Integer payable;

	/**
	 * 已收款
	 */
	private Integer received;

	/**
	 * 付款方式
	 */
	private Integer payForm;

	/**
	 * 账单创建日期
	 */
	private Date createDate;

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Integer getPayable() {
		return payable;
	}

	public void setPayable(Integer payable) {
		this.payable = payable;
	}

	public Integer getReceived() {
		return received;
	}

	public void setReceived(Integer received) {
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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
