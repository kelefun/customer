package com.funstill.customer.module.service;

import java.util.List;

import com.funstill.customer.base.service.BaseService;
import com.funstill.customer.module.model.Bill;
import com.funstill.customer.module.model.BillQuery;

public interface BillService extends BaseService<Bill> {
	public List<Bill> selectList(BillQuery query);

	public Integer selectCountList(BillQuery query);
}
