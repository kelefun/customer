package com.funstill.customer.base.model;

import java.util.List;

public class PageResult<T> extends ResultModel<List<T>>{

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public static <T> PageResult<T> fetchPage(Integer count, List<T> list){
		PageResult<T> result = new PageResult<>();
		result.setCount(count);
		result.setData(list);
		return result;
	}
}
