package com.yang.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yangzhijiang
 * @Date: 14:10 2017/12/19
 * @DESC:
 */
@Component
@ConfigurationProperties(prefix = "weixin")
public class WxConfig {

    private String notifyUrl;

    private String payUrl;

    private String partnerId;

    private String openidUrl;

    private String accessTokenUrl;

    private String appidxcx;

    private String appidpub;

    private String mchid;

    private String key;

    private String secretxcx;

    private String secretpub;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getOpenidUrl() {
        return openidUrl;
    }

    public void setOpenidUrl(String openidUrl) {
        this.openidUrl = openidUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getAppidxcx() {
        return appidxcx;
    }

    public void setAppidxcx(String appidxcx) {
        this.appidxcx = appidxcx;
    }

    public String getAppidpub() {
        return appidpub;
    }

    public void setAppidpub(String appidpub) {
        this.appidpub = appidpub;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecretxcx() {
        return secretxcx;
    }

    public void setSecretxcx(String secretxcx) {
        this.secretxcx = secretxcx;
    }

    public String getSecretpub() {
        return secretpub;
    }

    public void setSecretpub(String secretpub) {
        this.secretpub = secretpub;
    }
}
