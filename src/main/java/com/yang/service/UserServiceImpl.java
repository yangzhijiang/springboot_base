package com.yang.service;


import com.yang.dao.entity.User;
import com.yang.dao.repository.UserRepository;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    public static  final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public User getById(Long id){

        logger.info("this is test");
        return userRepository.findOne(id);

    }

}
