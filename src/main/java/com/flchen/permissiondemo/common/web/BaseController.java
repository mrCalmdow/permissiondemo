package com.flchen.permissiondemo.common.web;


import com.flchen.permissiondemo.common.mo.ResponseMO;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Beldon.
 * @create 2017-11-3 下午2:26
 */
@Slf4j
public abstract class BaseController {

	public <T> ResponseMO<T> success(T resMo, String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setMsg(msg);
		responseMO.setData(resMo);
		return responseMO;
	}

	public <T> ResponseMO<T> success(T resMo) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setData(resMo);
		return responseMO;
	}

	public <T> ResponseMO<T> success() {
		return new ResponseMO<>();
	}

	public <T> ResponseMO<T> success(String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setMsg(msg);
		return responseMO;
	}

	public <T> ResponseMO<T> error(T resMo, String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setResponseCodeFailure();
		responseMO.setMsg(msg);
		responseMO.setData(resMo);
		return responseMO;
	}

	public <T> ResponseMO<T> error(String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setResponseCodeFailure();
		responseMO.setMsg(msg);
		return responseMO;
	}

	public <T> ResponseMO<T> custom(int code, String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setCode(code);
		responseMO.setMsg(msg);
		return responseMO;
	}

	public <T> ResponseMO<T> custom(T resMo, int code, String msg) {
		ResponseMO<T> responseMO = new ResponseMO<T>();
		responseMO.setCode(code);
		responseMO.setMsg(msg);
		responseMO.setData(resMo);
		return responseMO;
	}
}
