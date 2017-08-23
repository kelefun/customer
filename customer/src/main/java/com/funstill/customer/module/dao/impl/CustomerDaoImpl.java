package com.funstill.customer.module.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.funstill.customer.module.dao.CustomerDao;
import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.model.CustomerQuery;
import com.funstill.customer.util.HsqlUtil;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Integer insert(Customer record) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "insert into customer (realname,mobile,extra,create_date) values (?,?,?,now())";
		List<Object> params = new ArrayList<>();
		params.add(record.getRealname());
		params.add(record.getMobile());
		params.add(record.getExtra());
		Integer result = hsql.updateByPreparedStatement(sql, params);
		hsql.releaseConn();
		return result;
	}

	@Override
	public Integer delete(Long id) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "delete from customer where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		Integer result = hsql.updateByPreparedStatement(sql, params);
		hsql.releaseConn();
		return result;
	}

	@Override
	public Integer update(Customer record) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "update customer set";
		List<Object> params = new ArrayList<>();
		if (StringUtils.isNotBlank(record.getMobile())) {
			sql += " mobile = ? ,";
			params.add(record.getMobile());
		}
		if (StringUtils.isNotBlank(record.getRealname())) {
			sql += " realname = ? ,";
			params.add(record.getRealname());
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
	public Customer selectById(Long id) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "SELECT * FROM customer where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		ResultSet resultSet = hsql.executeQuery(sql, params);
		Customer customer = new Customer();
		try {
			while (resultSet.next()) {
				customer.setId(resultSet.getLong("id"));
				customer.setMobile(resultSet.getString("mobile"));
				customer.setRealname(resultSet.getString("realname"));
				customer.setExtra(resultSet.getString("extra"));
				customer.setCreateDate(resultSet.getDate("create_date"));
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
		return customer;
	}

	@Override
	public List<Customer> selectList(CustomerQuery query) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "SELECT * FROM customer where 1 = 1";
		List<Object> params = new ArrayList<>();
		if (StringUtils.isNotBlank(query.getMobile())) {
			sql += "and mobile = ? ";
			params.add(query.getMobile());
		}
		if (StringUtils.isNotBlank(query.getRealname())) {
			sql += "and realname = ? ";
			params.add(query.getRealname());
		}
		if (StringUtils.isNotBlank(query.getExtra())) {
			sql += "and extra = ? ";
			params.add(query.getExtra());
		}
		
		if (query.isSetPage()) {
			sql += " limit ? offset ? ";
			params.add(query.getLimit());
			params.add(query.getStartRow());
		}
		ResultSet resultSet = hsql.executeQuery(sql, params);
		List<Customer> customerList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getLong("id"));
				customer.setMobile(resultSet.getString("mobile"));
				customer.setRealname(resultSet.getString("realname"));
				customer.setExtra(resultSet.getString("extra"));
				customer.setCreateDate(resultSet.getDate("create_date"));
				
				customerList.add(customer);
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
		return customerList;
	}

	@Override
	public Integer selectCountList(CustomerQuery query) {
		HsqlUtil hsql = new HsqlUtil();
		hsql.getConnection();
		String sql = "SELECT count(1) FROM customer where 1 = 1";
		List<Object> params = new ArrayList<>();
		if (StringUtils.isNotBlank(query.getMobile())) {
			sql += "and mobile = ? ";
			params.add(query.getMobile());
		}
		if (StringUtils.isNotBlank(query.getRealname())) {
			sql += "and realname = ? ";
			params.add(query.getRealname());
		}
		if (StringUtils.isNotBlank(query.getExtra())) {
			sql += "and extra = ? ";
			params.add(query.getExtra());
		}
		
		if (query.isSetPage()) {
			sql += " limit ? offset ? ";
			params.add(query.getLimit());
			params.add(query.getStartRow());
		}
		ResultSet resultSet = hsql.executeQuery(sql, params);
		try {
			while (resultSet.next()) {
				return resultSet.getInt(1);
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
		return 0;
	}

}
