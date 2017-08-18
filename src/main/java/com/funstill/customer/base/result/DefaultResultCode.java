package com.funstill.customer.base.result;

/**
 * DefaultResultCode<br>
 * ResultCode接口默认实现,所有项目<b>通用</b>状态码<br>
 * 注意: 涉及到具体业务请在具体项目中再实现ResultCode
 */
public enum DefaultResultCode implements ResultCode {
	SUCCESS(0, "success"),
	// 常用通用异常,格式-100-0-*
	SYSTEM_ERROR(10000, "内部异常"),
	DAO_ERROR(10001, "数据层异常"),
	ILLEGAL_ARGUMENT(10002, "非法参数"),
	ERROR_UNKNOWN_REASON(10003, "未知异常"),

	// 权限相关 格式-100-1-*
	AUTH_ERROR_NOT_RIGHT(10011, "没有权限"), 
	AUTH_ERROR_NOT_LOGIN(10012, "请登陆后重试"),

	// 数据操作 格式-100-2-*
	DATA_ERROR_SELECT_IS_NULL(10020, "该数据不存在或已被删除"), 
	DATA_ERROR_INSERT(10021, "新增失败"),
	DATA_ERROR_UPDATE(10022,"更新失败"), 
	DATA_ERROR_DELETE(10023, "删除失败"),

	// 上传文件  格式-100-3-*
	UPLOAD_ERROR(10030, "上传失败"),
	
	// 数据校验 格式-100-4-*
	VERIFY_MOBILE_ERROR(10040, "手机格式错误"),
	VERIFY_EMAIL_ERROR(10041, "邮件格式错误"),
	VERIFY_CODE_EXPIRED(10042, "验证码已经失效，请重新获取。"),
	VERIFY_CODE_ERROR(10045, "验证码输入错误。"),
	
	// 请求格式-100-5-*
	REQUEST_ERROR_FREQUENT(10500, "请求过于频繁,请稍后再试"),
	REQUEST_ERROR_METHOD(10501, "请求方法有误-GET?POST?PUT?DELETE?"),
	
	REQUEST_ERROR_FAIL(400, "请求语法格式有误"),
	REQUEST_ERROR_NOT_AUTH(401, "未授权"),
	REQUEST_ERROR_FORBIDDEN(403,"没有权限,禁止访问"),
	REQUEST_ERROR_NOT_FIND(404, "您访问的地址不存在或已删除"),
	REQUEST_ERROR_SERVER(503, "服务器内部异常"),
	
	REQUEST_ERROR_ACCESS(500,"远程请求失败");

	private int code;

	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return code + ":" + msg;
	}

	private DefaultResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
