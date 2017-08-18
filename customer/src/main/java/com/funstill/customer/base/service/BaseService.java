package com.funstill.customer.base.service;

import java.io.Serializable;

import com.funstill.customer.base.dao.BaseDao;
import com.funstill.customer.base.model.BaseModel;

public interface BaseService<T extends BaseModel> extends Serializable {

	Integer insert(T record);

	Integer deleteById(Long id);

	Integer updateById(T record);

	T selectById(Long id);

	BaseDao<T> getDao();
}
