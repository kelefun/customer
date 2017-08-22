package com.funstill.customer.module.dao;

import java.util.List;

import com.funstill.customer.base.dao.BaseDao;
import com.funstill.customer.module.model.Bill;
import com.funstill.customer.module.model.BillQuery;

public interface BillDao extends BaseDao<Bill>{
	public List<Bill> selectList(BillQuery query); // 全部查询
	
	public Integer selectCountList(BillQuery query); // 全部查询
}
