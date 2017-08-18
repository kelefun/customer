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
		module = t;
	}

	/**
	 * 结果返回的code
	 */
	private ResultCode code = DefaultResultCode.SUCCESS;
	/**
	 * 备注信息
	 */
	private String errMsg;
	/**
	 * 结果返回的业务数据
	 */
	private T module;

	/**
	 * 操作是否成功
	 * @return
	 */
	public boolean isSuccess() {
		return DefaultResultCode.SUCCESS == code ? true : false;
	}

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
	public void putError(ResultCode error, String msg) {
		this.code = error;
		if (StringUtils.isBlank(msg)) {
			this.errMsg = error.getMsg();
		} else {
			this.errMsg = msg;
		}
	}

	/**
	 * 填充错误信息
	 * @param error
	 */
	public void putError(ResultModel<?> error) {
		this.code = error.getCode();
		if (StringUtils.isBlank(error.getErrMsg())) {
			this.errMsg = error.getCode().getMsg();
		} else {
			this.errMsg = error.getErrMsg();
		}
	}

	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public T getModule() {
		return module;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
