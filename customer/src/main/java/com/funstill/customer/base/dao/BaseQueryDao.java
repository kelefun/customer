package com.funstill.customer.base.dao;

import com.funstill.customer.base.model.BaseModel;
import com.funstill.customer.base.model.PageModel;

public interface BaseQueryDao<T extends BaseModel,Q extends PageModel> extends BaseDao<T>{
	public PageModel query(Q query); // 分页查询
}
