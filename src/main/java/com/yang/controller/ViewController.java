package com.yang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view() throws Exception {
        logger.info("view test");
        return "add";
    }

    @RequestMapping("/errorview")
    public String error() throws Exception {
        logger.info("view test");
        return "errora.html";

    }
}
