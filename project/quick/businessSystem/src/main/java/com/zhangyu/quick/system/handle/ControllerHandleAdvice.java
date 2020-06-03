package com.zhangyu.quick.system.handle;

import com.zhangyu.quick.system.controller.QuickTestController;
import com.zhangyu.server.dto.ResponseDto;
import com.zhangyu.server.exception.ValidatorException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice(assignableTypes = {QuickTestController.class})
@ResponseBody
public class ControllerHandleAdvice {


    @ExceptionHandler(value = {Exception.class,
            ValidatorException.class
    })
    public ResponseDto exceptionHandle(HttpServletRequest request, Exception exception, ValidatorException validatorException) {
        ResponseDto responseDto = new ResponseDto();
        if (validatorException != null) {
            responseDto.setMessage(validatorException.getMessage() );
            return responseDto;
        }
        return responseDto;
    }

}