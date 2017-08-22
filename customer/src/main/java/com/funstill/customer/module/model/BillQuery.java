package com.funstill.customer.module.model;

import java.util.Date;

import com.funstill.customer.base.model.PageModel;

/**
 * 
 * @author liukaiyang 2017年8月15日
 */
public class BillQuery extends PageModel{
	

	
	/**
	 * 账单创建日期
	 */
	private Date createDate;


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
