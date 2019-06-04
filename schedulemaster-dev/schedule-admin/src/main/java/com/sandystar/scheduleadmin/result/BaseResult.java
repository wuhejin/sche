package com.sandystar.scheduleadmin.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**

 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable {
	public final static int SUCCESS = 0;
	public final static int FAIL = 1;
	public final static int UNLOGIN = -1;
	private int code;

	private String msg;

	private List<T> data;


	public BaseResult(int status, String msg) {
		this.code = status;
		this.msg = msg;
	}

	public BaseResult() {
	}

	public BaseResult(List<T> content) {
		if (content == null) {
			this.code = FAIL;
			this.msg = "失败";
		} else {

			this.code = SUCCESS;
			this.msg = "成功";
			this.data = content;
		}
	}


	public int getCode() {
		return code;
	}

	public void setCode(int status) {
		this.code = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> content) {
		this.data = content;
	}
}
