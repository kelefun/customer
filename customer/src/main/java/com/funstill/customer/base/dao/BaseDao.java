package com.funstill.customer.base.dao;

import com.funstill.customer.base.model.BaseModel;

public interface BaseDao<T extends BaseModel> {
	public Integer insert(T record); // 增

	public Integer delete(Long id); // 单条删除

	public Integer update(T record); // 修改

	public T selectById(Long id); // 单记录查询



}
