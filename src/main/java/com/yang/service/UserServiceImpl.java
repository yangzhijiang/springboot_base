package com.yang.service;


import com.yang.dao.entity.User;
import com.yang.dao.repository.UserJapRepository;
import com.yang.dao.repository.UserRepository;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceImpl {

    public static  final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public Page<User> getById(final User user){

        logger.info("this is test");
        PageRequest pageable = new PageRequest(0,15);
        Page<User> pages = userRepository.findAll(pageable);
        return pages;

    }
    public User getById(Long id){

        return userRepository.findOne(id);

    }

    public List<User> getAll(){

        return userRepository.findAll();

    }


}
