package com.yang.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: yangzhijiang
 * @Date: 14:11 2017/12/19
 * @DESC:
 */
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliConfig {
}
