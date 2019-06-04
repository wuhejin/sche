package com.sandystar.scheduleadmin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CommonUitls {


    private static final Logger logger = LoggerFactory.getLogger(CommonUitls.class);

    //jenkins build status
    public static final int STATUS_SUCCESS_BUILD = 0;
    public static final int STATUS_NOT_BUILD = 1;
    public static final int STATUS_BUILDING = 2;
    public static final int STATUS_FAILED_BUILD = 3;
    public static final int STATUS_ABSORB_BUILD = 4;

    // status
    public static final int SUCCESS_STATUS = 0;
    public static final int FAILED_STATUS = 1;
    public static final int PART_SUCCESS = 2;


    public static final int REPORT_STATUS_SUCCESS = 0;
    public static final int REPORT_STATUS_BUILDING = 1;
    public static final int REPORT_STATUS_FAILED = 2;
    public static final int REPORT_STATUS_NOT_BUILD = 3;

    /** 首次提测 **/
    public static final int BUILD_TYPE_FIRST = 1;
    /** 回归提测 **/
    public static final int BUILD_TYPE_REBUILD = 2;
    /** 重新提交 **/
    public static final int BUILD_TYPE_RECOMMIT = 3;

    public static final String HTTP_URL_HEAD = "http://";

    /** 平台类型（1： andriod, 2: ios） **/
    public static final int ANDRIOD_PLATFORM = 1;
    public static final int IOS_PLATFORM = 2;

    //performance build status
    public static final int PERFORMANCE_SUCCESS_BUILD = 0;
    public static final int PERFORMANCE_NOT_BUILD = 1;
    public static final int PERFORMANCE_STATUS_BUILDING = 2;
    public static final int PERFORMANCE_FAILED_BUILD = 3;



    /**
     * Description: 获取submit服务的地址
     * Author:  suwenlong
     * Date: 2018/5/28 11:46
    **/
    public static String getServerUrl(){

        try {
            String host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("get server host Exception e:", e);
        }

        return "";
    }

    /**
     * Description: 根据apkPath 获取对应app的icon.(解析的时候生成)
    **/
    public static String getIconByBuildId(String apkPath){

        return "";
    }


    /**
     * Description: 根据build生成callbackId。 callBackId = "X"+buildId ;   X 表示平台； P代表性能测试平台，T:提测平台。
     * Author: suwenlong
     * Date: 2018/7/13
    **/
    public static String ConposeCallbackId(Long buildId, String systemFlag){
        return systemFlag + buildId;
    }

    public static boolean isPerformanceSystem(String callBackIdStr){
        return callBackIdStr != null && callBackIdStr.startsWith("P");
    }


}
