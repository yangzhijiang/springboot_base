package com.yang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yang.common.utils.GsonUtil;
import com.yang.dao.entity.User;
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

        User user = new User();
        user.setNickName("哈哈");
        user.setPhone("15135163108");
        User user1 = userService.getById(id);

        return JSON.toJSONString(user1);
    }

    @RequestMapping("/getList")
    public String getList() throws Exception {

        logger.info("rest test");

        User user = new User();
        user.setNickName("哈哈");
        user.setPhone("15135163108");

        Page<User> pages = userService.getById(user);

        JSONObject obj = new JSONObject();
        obj.put("ele",pages.getTotalElements());
        obj.put("total",pages.getTotalPages());
        obj.put("list",pages.getContent());
        return obj.toJSONString();
    }

    @RequestMapping("/getrList")
    public String getrList() throws Exception {

        logger.info("rest test");

        User user = new User();
        user.setNickName("哈哈");
        user.setPhone("15135163108");

        List<User> pages = userService.getAll();

        return JSON.toJSONString(pages);
    }
}
