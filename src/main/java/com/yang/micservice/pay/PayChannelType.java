package com.yang.micservice.pay;

/**
 * @Author: yangzhijiang
 * @Date: 13:44 2017/12/19
 * @DESC:
 */
public enum PayChannelType {

    WXAPPPAY("wxapppay","微信APP支付"),WXWEBPAY("wxwebpay","微信网页支付"),WXXCXPAY("wxxcxpay","微信小程序支付"),ALIAPPPAY("aliapppay","支付宝APP支付"),ALIWEBPAY("aliwebpay","支付宝网页支付");

    private String type;

    private String desc;

    public static PayChannelType getPayChannelByType(String type){

        for(PayChannelType payChannelType : PayChannelType.values()){
            if(payChannelType.getType().equals(type)){
                return payChannelType;
            }
        }

        return null;
    }

    PayChannelType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
