package com.zhangyu.quick.controller.advice;

import com.zhangyu.quick.controller.QuickTestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {QuickTestController.class})
@ResponseBody
public class TestControllerAdvice {


    @ExceptionHandler(value = {Exception.class,
            RuntimeException.class
    })
    public String exceptionHandle(HttpServletRequest request, Exception exception, RuntimeException runtimeException) {
        if (runtimeException != null) {
            return runtimeException.getMessage();
        }
        return "OK";
    }

}
