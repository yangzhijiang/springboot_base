package com.yang.micservice.pay.wxpay;

import com.alibaba.fastjson.JSON;
import com.yang.common.config.WxConfig;
import com.yang.common.exception.ServiceException;
import com.yang.common.exception.SysException;
import com.yang.common.utils.HttpClientUnit;
import com.yang.micservice.pay.PayChannelType;
import com.yang.micservice.pay.PayGateway;
import com.yang.micservice.pay.wxpay.utils.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: yangzhijiang
 * @Date: 12:59 2017/12/19
 * @DESC:
 */

@Service
public class WxPay implements PayGateway {

    public  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxConfig wxConfig;

    @Override
    public String requestPay(Map<String, Object> datas) throws SysException{

        Map<String,String> params = new HashMap<String,String>();

        try{
            //业务参数
            params.put("body",datas.get("body").toString());
            params.put("out_trade_no",datas.get("outTradeNo").toString());
            params.put("total_fee",datas.get("totalPrice").toString());
            params.put("spbill_create_ip",datas.get("spbillCreateIp").toString());

            if(PayChannelType.WXAPPPAY.getType().equals(datas.get("wxpaytype"))){
                params.put("appid",wxConfig.getAppidpub());
                params.put("trade_type","APP");
            }else if(PayChannelType.WXWEBPAY.getType().equals(datas.get("wxpaytype"))){
                params.put("openid",datas.get("openid").toString());
                params.put("trade_type","JSAPI");
                params.put("appid",wxConfig.getAppidpub());
            }else{
                params.put("trade_type","JSAPI");
                params.put("openid",getOpenId(datas.get("codes").toString()));
                params.put("appid",wxConfig.getAppidxcx());
            }

            //平台参数

            params.put("mch_id",wxConfig.getMchid());
            params.put("nonce_str",WXPayUtil.generateNonceStr());
            params.put("notify_url",wxConfig.getNotifyUrl());
            params.put("sign_type","MD5");
    //        签名
            datas.put("sign", WXPayUtil.generateSignature(params,wxConfig.getKey()));

            String resultXml = HttpClientUnit.post(wxConfig.getPayUrl(),WXPayUtil.mapToXml(params));
            if(StringUtils.isEmpty(resultXml)){
                throw new ServiceException(400,"调用微信支付下单失败!");
            }
            Map<String,String> result = WXPayUtil.xmlToMap(resultXml);
            if(null == result||result.isEmpty()){
                logger.error("支付结果转换失败，resultxml : {} 转换为map时map为空！",resultXml);
                throw new ServiceException(400,"调用微信支付下单失败!");
            }
            if(!"SUCCESS".equals(result.get("return_code"))){
                logger.error("返回结果return_code is fail，return_msg : {} ！",result.get("return_msg"));
                throw new ServiceException(400,"调用微信支付下单失败!");
            }else if("SUCCESS".equals(result.get("result_code"))){
                return createCallStr(result.get("prepay_id"),datas.get("wxpaytype").toString());
            }else{
                logger.error("返回结果result_code is fail，err_code : {},err_code_des : {} ",datas.get("err_code").toString(),datas.get("err_code_des").toString());
                throw new ServiceException(400,"调用微信支付下单失败!");
            }
        }catch (ServiceException e){
            throw e;
        }catch (SysException e){
            throw e;
        }catch (Exception e) {
            throw new SysException(500,e.getMessage());
        }
    }

    @Override
    public String paySelect(String transactionId) throws SysException{
        return null;
    }

    private String getOpenId(String code){


        return "";
    }

    private String createCallStr(String perPayId,String wxPayType){

        try{

            Map<String,String> preMap = new HashMap<String,String>();
            preMap.put("timeStamp",String.valueOf(WXPayUtil.getCurrentTimestamp()));
            preMap.put("nonceStr",WXPayUtil.generateNonceStr());

            if(PayChannelType.WXAPPPAY.getType().equals(wxPayType)){
                preMap.put("partnerId",wxConfig.getPartnerId());
                preMap.put("prepayId",perPayId);
                preMap.put("package","Sign=WXPay");
                preMap.put("sign",WXPayUtil.generateSignature(preMap,wxConfig.getKey()));
            }else{
                preMap.put("appId",wxConfig.getAppidpub());
                preMap.put("package","prepay_id="+perPayId);
                preMap.put("signType","MD5");
                preMap.put("paySign",WXPayUtil.generateSignature(preMap,wxConfig.getKey()));
            }



            return JSON.toJSONString(preMap);

        }catch (Exception e){
            throw new SysException(500,e.getMessage());
        }

    }
}
