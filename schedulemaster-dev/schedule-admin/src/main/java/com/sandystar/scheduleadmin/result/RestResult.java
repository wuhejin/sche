package com.sandystar.scheduleadmin.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sandystar.scheduleadmin.utils.ErrorCode;

import java.io.Serializable;

/**
 * Description: 返回结果对象
 * Author:  suwenlong
 * Date: 2018/4/16 19:33
**/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("")

public class RestResult<T> implements Serializable {


    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "成功";

    public static final String FAILED_CODE = "1";
    public static final String FAILED_MSG = "失败";

    public static final String ARG_ERROR_MSG = "参数异常";
    public static final String ARG_ERROR_CODE = "1000";

    public static RestResult SUCCESS = new RestResult();
    public static RestResult FAILED = new RestResult(FAILED_CODE, FAILED_MSG);


    private String msg;

    private String detailMsg;

    private String code;

    private T data;

    public RestResult(){
        this.msg = SUCCESS_MSG;
        this.code = SUCCESS_CODE;
    }

    public RestResult(T data){
        this.data = data;
        this.msg = SUCCESS_MSG;
        this.code = SUCCESS_CODE;
    }

    public RestResult(String code , String msg){
        this.code = code;
        this.msg = msg;
    }

    public RestResult(String code , String msg, String detailMsg){

        this.code = code;
        this.msg = msg;
        this.detailMsg = detailMsg;
    }

    public RestResult(ErrorCode error){
        this.code = error.getErrorCodeStr();
        this.msg = error.getErrorMsg();
    }

    public RestResult(ErrorCode error, String detailMsg){
        this.code = error.getErrorCodeStr();
        this.msg = error.getErrorMsg();
        this.detailMsg = detailMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }
}
