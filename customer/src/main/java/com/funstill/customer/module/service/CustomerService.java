package com.funstill.customer.module.service;

import java.util.List;

import com.funstill.customer.base.service.BaseService;
import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.model.CustomerQuery;

public interface CustomerService extends BaseService<Customer>{
	
	public List<Customer> selectList(CustomerQuery query); 
	
	public Integer selectCountList(CustomerQuery query);
	
}
