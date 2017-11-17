package com.yang.service.enums;

/**
 * @Author: yangzhijiang
 * @Date: 11:53 2017/11/17
 * @DESC:
 */
public enum CommodifyStatusEnum {

    ONLINR(1,"上线"),OFFLINE(2,"下线");

    private int code;

    private String describe;


    CommodifyStatusEnum(int i, String 上线) {
    }

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

}
