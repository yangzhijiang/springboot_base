package com.yang.controller;


import com.yang.common.exception.RestControllerException;
import com.yang.dao.entity.User;
import com.yang.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class TestController {

    public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getuser")
    public User getUser(Long id) throws Exception {

        logger.info("rest test");
        if(true){
            throw new RestControllerException("restException");
        }else{
            User user = userService.getById(id);
            return user;
        }

    }
}
