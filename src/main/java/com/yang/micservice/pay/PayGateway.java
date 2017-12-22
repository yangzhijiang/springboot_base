package com.yang.micservice.pay;

import com.yang.common.exception.SysException;

import java.util.Map;

/**
 * @Author: yangzhijiang
 * @Date: 19:03 2017/12/18
 * @DESC:
 */
public interface PayGateway {

    String requestPay(Map<String,Object> datas) throws SysException;

    String paySelect(String transactionId ) throws SysException;

}
