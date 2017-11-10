package com.yang.controller;

import com.yang.dao.entity.User;
import com.yang.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getuser")
    public User getUser(Long id) throws Exception {

        logger.info("rest test");

        User user = userService.getById(id);
        return user;
    }
}
