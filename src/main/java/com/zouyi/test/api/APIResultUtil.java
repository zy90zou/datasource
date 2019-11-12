package com.zouyi.test.api;


public class APIResultUtil {

	/*********************************请求成功提示信息***************************************/
	@SuppressWarnings("rawtypes")
	public static APIResult success(Integer code, String msg) {
		return new APIResult(code, msg);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static APIResult success(Integer code, String msg, Object data) {
		return new APIResult(code, msg, data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static APIResult success(APIResultEnum apiResultEnum, Object data) {
		return new APIResult(apiResultEnum.getCode(), apiResultEnum.getMsg(), data);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static APIResult success(Object o) {
		return new APIResult(APIResultEnum.SUCCESS.getCode(), APIResultEnum.SUCCESS.getMsg(), o);
	}

	/*********************************请求失败提示信息***************************************/
	@SuppressWarnings("rawtypes")
	public static APIResult error(Integer code, String msg) {
		return new APIResult(code, msg);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static APIResult error(Integer code, String msg, Object data) {
		return new APIResult(code, msg, data);
	}

	public static APIResult error(APIResultEnum apiResultEnum) {
		return new APIResult(apiResultEnum.getCode(), apiResultEnum.getMsg());
	}

	public static APIResult error(APIResultEnum apiResultEnum,Object data) {
		return new APIResult(apiResultEnum.getCode(), apiResultEnum.getMsg(),data);
	}
}
