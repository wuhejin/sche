package com.sandystar.scheduleadmin.utils;

public enum ErrorCode {


    //commons

    SUCCESS(0, "成功"),
    FAILED(1, "失败"),

    UNKNOW_EXCEPTION(10000, "未知异常"),
    PARAM_ERROR(10001, "参数错误"),
    ALREADY_EXIST(10002, "记录已经存在！"),
    CONTENT_ALREADY_EXIST(10003, "content内容重复，请修改！"),

    NOT_CONFIG(10004, "内容未配置，请检查！"),

    JENKINS_INVOKE_ERROR(10010,"调用jenkins失败"),


    //提测平台
    PLATFORM_ALREADY_EXIST(20001, "平台名称已经存在！"),


    //性能测试
    PROJECT_NAME_EXIST(30001, "项目名称已经存在！"),

    SCENE_NAME_EXIST(30011, "场景名称已经存在！"),

    BRANCH_NAME_EXIST(30021, "分支名称已经存在！"),

    MAX_TIMER_LIMIT(30031,"定时器已经达到最大限制！");


    private String errorMsg;

    private int errorCode;

    ErrorCode(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorCodeStr() {
        return String.valueOf(errorCode);
    }


}
