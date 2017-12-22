package com.yang.micservice.pay;

import com.yang.micservice.pay.alipay.AliPay;
import com.yang.micservice.pay.wxpay.WxPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: yangzhijiang
 * @Date: 11:52 2017/12/19
 * @DESC:
 */

@Service
public class PayChannelFactoryImpl implements PayChannelFactory {

    @Autowired
    private WxPay wxPay;

    @Autowired
    private AliPay aliPay;

    @Override
    public PayGateway payChannelRoute(String payChannelType) {

        switch (PayChannelType.getPayChannelByType(payChannelType)){
            case WXAPPPAY:
            case WXWEBPAY:
            case WXXCXPAY:
                return wxPay;
            case ALIAPPPAY:
            case ALIWEBPAY:
                return aliPay;
            default:
                return wxPay;
        }
    }
}
