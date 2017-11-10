package com.yang.common.exceptionhandler;

import com.yang.common.exception.ControllerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

//@ControllerAdvice
//@Order(Ordered.LOWEST_PRECEDENCE)
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerException.class)
    public String exception(Exception e, Model model){
        model.addAttribute("code","fail");
        model.addAttribute("msg",e.getMessage());
        return "errora.html";
    }

}





