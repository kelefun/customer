package com.funstill.customer.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.funstill.customer.module.dao.CustomerDao;
import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.model.CustomerQuery;
import com.funstill.customer.module.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Resource
	public CustomerDao customerDao;

	@Override
	public Integer insert(Customer record) {
		return getDao().insert(record);
	}

	@Override
	public Integer deleteById(Long id) {
		return getDao().delete(id);
	}

	@Override
	public Integer updateById(Customer record) {
		return getDao().update(record);
	}

	@Override
	public Customer selectById(Long id) {
		return getDao().selectById(id);
	}

	@Override
	public CustomerDao getDao() {
		return customerDao;
	}

	@Override
	public List<Customer> selectList(CustomerQuery query) {
		return getDao().selectList(query);
	}

	@Override
	public Integer selectCountList(CustomerQuery query) {
		return getDao().selectCountList(query);
	}

}
