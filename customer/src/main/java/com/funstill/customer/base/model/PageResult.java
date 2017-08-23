package com.funstill.customer.base.model;

public class PageResult<T> extends ResultModel<T>{

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
