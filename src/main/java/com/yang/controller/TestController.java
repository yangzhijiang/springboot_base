package com.yang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yang.dao.entity.UserEntity;
import com.yang.service.OrderService;
import com.yang.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getuser")
    public String getUser(Long id) throws Exception {

        logger.info("rest test");

        UserEntity userEntity = new UserEntity();
        userEntity.setNickName("哈哈");
        userEntity.setPhone("15135163108");
        UserEntity userEntity1 = userService.getById(id);

        return JSON.toJSONString(userEntity1);
    }

    @RequestMapping("/getList")
    public String getList() throws Exception {

        logger.info("rest test");

        UserEntity userEntity = new UserEntity();
        userEntity.setNickName("哈哈");
        userEntity.setPhone("15135163108");

        Page<UserEntity> pages = userService.getById(userEntity);

        JSONObject obj = new JSONObject();
        obj.put("ele",pages.getTotalElements());
        obj.put("total",pages.getTotalPages());
        obj.put("list",pages.getContent());
        return obj.toJSONString();
    }

    @RequestMapping("/getrList")
    public String getrList() throws Exception {

        logger.info("rest test");

        UserEntity userEntity = new UserEntity();
        userEntity.setNickName("哈哈");
        userEntity.setPhone("15135163108");

        List<UserEntity> pages = userService.getAll();

        return JSON.toJSONString(pages);
    }
}
