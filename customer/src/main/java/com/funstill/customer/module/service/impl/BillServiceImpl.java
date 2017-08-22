package com.funstill.customer.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.funstill.customer.module.dao.BillDao;
import com.funstill.customer.module.model.Bill;
import com.funstill.customer.module.model.BillQuery;
import com.funstill.customer.module.service.BillService;

@Service("billService")
public class BillServiceImpl implements BillService{
	
	@Resource
	public BillDao billDao;

	@Override
	public Integer insert(Bill record) {
		return getDao().insert(record);
	}

	@Override
	public Integer deleteById(Long id) {
		return getDao().delete(id);
	}

	@Override
	public Integer updateById(Bill record) {
		return getDao().update(record);
	}

	@Override
	public Bill selectById(Long id) {
		return getDao().selectById(id);
	}

	@Override
	public BillDao getDao() {
		return billDao;
	}

	@Override
	public List<Bill> selectList(BillQuery query) {
		return getDao().selectList(query);
	}

	@Override
	public Integer selectCountList(BillQuery query) {
		return getDao().selectCountList(query);
	}

}
