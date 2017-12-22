package com.yang.micservice.pay;

/**
 * @Author: yangzhijiang
 * @Date: 19:01 2017/12/18
 * @DESC:
 */
public interface PayChannelFactory {

    PayGateway payChannelRoute(String payChannelType);

}
