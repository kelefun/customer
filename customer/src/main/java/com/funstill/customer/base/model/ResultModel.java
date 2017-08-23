package com.funstill.customer.base.model;

import org.apache.commons.lang3.StringUtils;

import com.funstill.customer.base.result.DefaultResultCode;
import com.funstill.customer.base.result.ResultCode;

public class ResultModel<T>{

	public ResultModel() {
		super();
	}

	public ResultModel(ResultCode code) {
		putError(code);
	}

	public ResultModel(T t) {
		this.setData(t);
	}

	/**
	 * 结果返回的code
	 */
	private ResultCode code = DefaultResultCode.SUCCESS;
	/**
	 * 备注信息
	 */
	private String msg;
	/**
	 * 结果返回的业务数据
	 */
	private T data;

	/**
	 * 设置操作成功
	 */
	public void markSuccess() {
		this.code = DefaultResultCode.SUCCESS;
	}

	/**
	 * 填充错误信息
	 * @param error
	 */
	public void putError(ResultCode error) {
		this.putError(error, null);
	}

	/**
	 * 填充错误信息
	 * @param error
	 * @param msg
	 */
	public void putError(ResultCode resutCode, String msg) {
		this.code = resutCode;
		if (StringUtils.isBlank(msg)) {
			this.setMsg(resutCode.getMsg());
		} else {
			this.setMsg(msg);
		}
	}

	/**
	 * 填充错误信息
	 * @param error
	 */
	public void putError(ResultModel<?> resultModel) {
		this.code = resultModel.getCode();
		if (StringUtils.isBlank(resultModel.getMsg())) {
			this.setMsg(resultModel.getCode().getMsg());
		} else {
			this.setMsg(resultModel.getMsg());
		}
	}

	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
