package com.yang;


import com.yang.common.interceptors.LogInterceptor;
import com.yang.common.interceptors.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Appliction extends WebMvcConfigurerAdapter {

    public static final Logger logger = LoggerFactory.getLogger(Appliction.class);

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private LogInterceptor logInterceptor;

    @Value("${spring.profiles.active}")
    private  String active;



    public static void main(String[] args) throws Exception {
        SpringApplication.run(Appliction.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/**");
    }

    @PostConstruct
    public void init(){

        logger.info("+++++++++运行环境+++++++++++\n" +
                    "++++++++++"+active+"++++++++\n"+
                    "++++++++++++++++++++++++++++\n");

    }
}
