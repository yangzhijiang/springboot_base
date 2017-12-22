package com.yang.micservice.pay.alipay;

import com.yang.micservice.pay.PayGateway;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: yangzhijiang
 * @Date: 12:59 2017/12/19
 * @DESC:
 */

@Service
public class AliPay implements PayGateway {


    @Override
    public String requestPay(Map<String, Object> datas) {
        return null;
    }

    @Override
    public String paySelect(String transactionId) {
        return null;
    }
}
