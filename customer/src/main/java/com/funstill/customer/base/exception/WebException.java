package com.funstill.customer.base.exception;

import com.funstill.customer.base.model.ResultModel;
import com.funstill.customer.base.result.ResultCode;

/**
 * 
 * @author liukaiyang 2017年7月5日
 */
@SuppressWarnings("rawtypes")
public class WebException extends RuntimeException {

	private static final long serialVersionUID = 110171140734985725L;
	
	private ResultModel resultModel;

	public WebException() {
		super();
	}

	public WebException(String msg) {
		super(msg);
	}

	public WebException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public WebException(Throwable throwable) {
		super(throwable);
	}

	public WebException(ResultModel resultModel) {
		super(resultModel.getMsg());
		this.resultModel = resultModel;
	}

	public WebException(ResultCode resultCode) {
		this(new ResultModel<>(resultCode));
	}

	public WebException(ResultCode resultCode, String msg) {
		ResultModel<Integer> resultModel = new ResultModel<>();
		resultModel.putError(resultCode, msg);
		this.resultModel = resultModel;
	}

	public WebException(ResultModel resultModel, Throwable throwable) {
		super(resultModel.getMsg(), throwable);
		this.resultModel = resultModel;
	}

	public WebException(ResultCode resultCode, Throwable throwable) {
		this(new ResultModel(resultCode), throwable);
	}

	public ResultModel getResultModel() {
		return resultModel;
	}

	public void setResultModel(ResultModel resultModel) {
		this.resultModel = resultModel;
	}
}
