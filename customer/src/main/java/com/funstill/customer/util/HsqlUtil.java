package com.funstill.customer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HsqlUtil {
	private Connection connection;

	// 定义sql语句的执行对象
	private PreparedStatement pstmt;

	// 定义查询返回的结果集合
	private ResultSet resultSet;

	/**
	 * 执行更新操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return 执行结果
	 * @throws SQLException
	 */
	public Integer updateByPreparedStatement(String sql, List<Object> params){
		Integer result = 0;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
		try{
			pstmt = connection.prepareStatement(sql);
			int index = 1;
			// 填充sql语句中的占位符
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}
	
		return result;
	}

	/*
	 * 执行一句查询的sql
	 */
	public ResultSet executeQuery(String sql, List<Object> params){
		ResultSet result = null;
		try{
			pstmt = connection.prepareStatement(sql);
			// 利用Statement对象执行参数的sql
			// 填充sql语句中的占位符
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i+1, params.get(i));
				}
			}
			result = pstmt.executeQuery();
		}catch(SQLException se){
			se.printStackTrace();
		}
		return result;
	}

	public Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver"); // 注册驱动
			connection = DriverManager.getConnection("jdbc:hsqldb:file:D:/data/customerDB", "SA", ""); // 获取连接
		} catch (Exception e) {
			throw new RuntimeException("get connection error!", e);
		}
		return connection;
	}

	/**
	 * 释放资源
	 */
	public void releaseConn() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
