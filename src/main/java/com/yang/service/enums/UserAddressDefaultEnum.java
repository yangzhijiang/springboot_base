package com.yang.service.enums;

/**
 * @Author: yangzhijiang
 * @Date: 15:20 2017/11/17
 * @DESC:
 */
public enum UserAddressDefaultEnum {

    DEFAULT(1,"默认"),NODEFAULT(0,"其他");

    UserAddressDefaultEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    private int code;

    private String describe;

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
