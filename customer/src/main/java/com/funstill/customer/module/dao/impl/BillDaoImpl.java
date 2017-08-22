package com.funstill.customer.module.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.funstill.customer.module.dao.BillDao;
import com.funstill.customer.module.model.Bill;
import com.funstill.customer.module.model.BillQuery;
import com.funstill.customer.util.HsqlUtil;

@Repository
public class BillDaoImpl implements BillDao {
//goods_name,goods_price,goods_number,
	@Override
	public Integer insert(Bill record) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "insert into bill (extra,payable,received,pay_form,create_date) values (?,?,?,?,?,?,?,now())";
		List<Object> params = new ArrayList<>();
//		params.add(record.getGoodsName());
//		params.add(record.getGoodsPrice());
//		params.add(record.getGoodsNumber());
		params.add(record.getExtra());
		params.add(record.getPayable());
		params.add(record.getReceived());
		params.add(record.getPayForm());
		Integer result = hsql.updateByPreparedStatement(sql, params);
		hsql.releaseConn();
		return result;
	}

	@Override
	public Integer delete(Long id) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "delete from bill where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		Integer result = hsql.updateByPreparedStatement(sql, params);
		hsql.releaseConn();
		return result;
	}

	@Override
	public Integer update(Bill record) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "update bill set";
		List<Object> params = new ArrayList<>();
		if (record.getReceived()!=null) {
			sql += " received = ? ,";
			params.add(record.getReceived());
		}
		if (StringUtils.isNotBlank(record.getExtra())) {
			sql += " extra = ? ,";
			params.add(record.getExtra());
		}
		sql += " update_date = now() where id = ?";
		params.add(record.getId());
		Integer result = hsql.updateByPreparedStatement(sql, params);
		hsql.releaseConn();
		return result;
	}


	@Override
	public Bill selectById(Long id) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "SELECT * FROM bill where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		ResultSet resultSet = hsql.executeQuery(sql, params);
		Bill bill = new Bill();
		try {
			while (resultSet.next()) {
				bill.setId(resultSet.getLong("id"));
//				bill.setName(resultSet.getString("goods_name"));
//				bill.setNumber(resultSet.getInt("goods_number"));
//				bill.setPrice(resultSet.getDouble("goods_price"));
				bill.setExtra(resultSet.getString("extra"));
				bill.setCreateDate(resultSet.getDate("create_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		hsql.releaseConn();
		return bill;
	}

	@Override
	public List<Bill> selectList(BillQuery query) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "SELECT * FROM bill where 1 = 1";
		List<Object> params = new ArrayList<>();
		if (query.getCreateDate()!=null) {
			sql += "and (? - create_date)DAY = 0 ";
			params.add(query.getCreateDate());
		}
		
		if (query.isPage()) {
			sql += " limit ? offset ? ";
			params.add(query.getPageSize());
			params.add(query.getStartRow());
		}
		ResultSet resultSet = hsql.executeQuery(sql, params);
		List<Bill> billList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Bill bill = new Bill();
				bill.setId(resultSet.getLong("id"));
//				bill.setMobile(resultSet.getString("mobile"));
//				bill.setRealname(resultSet.getString("realname"));
				bill.setExtra(resultSet.getString("extra"));
				bill.setCreateDate(resultSet.getDate("create_date"));
				
				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		hsql.releaseConn();
		return billList;
	}

	@Override
	public Integer selectCountList(BillQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
