package com.funstill.customer.module.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.funstill.customer.base.model.BaseModel;

/**
 * 
 * @author liukaiyang 2017年8月15日
 */
public class Customer extends BaseModel{
	
	/**
	 * 客户姓名
	 */
	private String realname;
	
	private String mobile;
	
	private String extra;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
