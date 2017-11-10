package com.yang.common.globalbean;

import com.google.gson.JsonObject;

public class ApiResult {

    public static final String SUCCESS_MESSAGE = "成功";
    public static final int SUCCESS_CODE = 1;

    public int code;

    public String message;

    public JsonObject data;



    private ApiResult(int code, String message, JsonObject data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResult success(JsonObject data){

        ApiResult apiResult = new ApiResult(SUCCESS_CODE,SUCCESS_MESSAGE,data);
        return apiResult;

    }

    public static ApiResult fail(int code,String message){

        ApiResult apiResult = new ApiResult(code,message,null);
        return apiResult;

    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}
