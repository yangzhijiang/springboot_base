package com.yang.controller;

import com.yang.common.exception.ControllerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @RequestMapping("/view")
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
