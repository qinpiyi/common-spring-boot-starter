package com.qinpiyi.common.response;

public class CommonResponseUtil {
	/**
	 * 数据请求返回码
	 */
	public static final int RESCODE_SUCCESS = 1000; // 成功
	public static final int RESCODE_SUCCESS_MSG = 1001; // 成功(有返回信息)
	public static final int RESCODE_EXCEPTION = 1002; // 请求抛出异常
	public static final int RESCODE_NOLOGIN = 1003; // 未登陆状态
	public static final int RESCODE_NOEXIST = 1004; // 查询结果为空
	public static final int RESCODE_NOAUTH = 1005; // 无操作权限
	public static final int RESCODE_FAIL = 1006; // 失败

	/**
	 * 成功请求,建议使用CommonResponse success(String msg, Object data)
	 * 
	 * @param data
	 * @return
	 */
	public static CommonResponse success(Object data, String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_SUCCESS_MSG);
		res.setData(data);
		res.setMsg(msg);
		return res;
	}

	public static CommonResponse success(Object data) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_SUCCESS);
		res.setData(data);
		return res;
	}

	public static CommonResponse success(String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_SUCCESS_MSG);
		res.setMsg(msg);
		return res;
	}

	public static CommonResponse success() {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_SUCCESS);
		return res;
	}

	/**
	 * 成功失败,建议使用CommonResponse fail(String msg, Object data)
	 * 
	 * @param data
	 * @return
	 */
	public static CommonResponse fail(Object data, String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_FAIL);
		res.setData(data);
		res.setMsg(msg);
		return res;
	}

	public static CommonResponse fail(Object data) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_FAIL);
		res.setData(data);
		return res;
	}

	public static CommonResponse fail(String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_FAIL);
		res.setMsg(msg);
		return res;
	}

	public static CommonResponse fail() {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_FAIL);
		return res;
	}

	/**
	 * 请求抛出异常
	 * 
	 * @param msg
	 * @return
	 */
	public static CommonResponse exception(String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_EXCEPTION);
		res.setMsg(msg);
		return res;
	}

	public static CommonResponse unKonwException() {
		CommonResponse res = new CommonResponse();
		res.setCode(RESCODE_EXCEPTION);
		res.setMsg("请稍后再试");
		return res;
	}

	/**
	 * 自定义
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static CommonResponse custom(Integer code, String msg) {
		CommonResponse res = new CommonResponse();
		res.setCode(code);
		res.setMsg(msg);
		return res;
	}
}
