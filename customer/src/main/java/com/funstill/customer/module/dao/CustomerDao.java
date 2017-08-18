package com.funstill.customer.module.dao;

import java.util.List;

import com.funstill.customer.base.dao.BaseDao;
import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.model.CustomerQuery;

public interface CustomerDao extends BaseDao<Customer>{
	public List<Customer> selectList(CustomerQuery query); // 全部查询
	
	public Integer selectCountList(CustomerQuery query); // 全部查询
}
