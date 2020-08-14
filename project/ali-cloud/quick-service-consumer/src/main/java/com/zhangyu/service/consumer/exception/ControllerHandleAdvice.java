/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/7/27    新增
 * ========    =======  ============================================
 */
package com.zhangyu.service.consumer.exception;

import com.zhangyu.service.consumer.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能说明:
 * 对管理人文件管理的Controller拦截，提供公共的异常返回方法
 *
 * @author
 * @Date 2020/07/27
 */
//@ControllerAdvice(assignableTypes = {
//    ManagerFileManagementController.class,
//    PublishRuleController.class,
//    SaleChannelH5Controller.class
//})

@ControllerAdvice(basePackages = {
        "com.zhangyu.service.consumer.controller"
})
@ResponseBody
@Slf4j
public class ControllerHandleAdvice {

    @ExceptionHandler(value = {
            Exception.class
    })
    public ResponseData exceptionHandle(HttpServletRequest request, Exception exception) {
        ResponseData responseData = new ResponseData();
        if (exception != null) {
            // log.error("\r\n【this error Class】：{}\r\n【error message】：{}\r\n", getClass());
            log.error("\r\n【{}】--【error message】:{}", Thread.currentThread().getId(), exception.getLocalizedMessage(), exception);
            responseData.setMessage(exception.getMessage());
            responseData.setCode(500);
            return responseData;
        }
        responseData.setCode(-1);
        return responseData;
    }

//    @ExceptionHandler(value = {
//            ValidatorException.class
//    })
//    public ResponseData validatorExceptionHandle(HttpServletRequest request, ValidatorException validatorException) {
//        ResponseData responseData = new ResponseData();
//        if (validatorException != null) {
//            // log.error("\r\n【this error Class】：{}\r\n【error message】：{}\r\n", getClass());
//            log.error("\r\n【{}】--【error message】:{}", Thread.currentThread().getName(), validatorException.getLocalizedMessage(), validatorException);
//            responseData.setMessage(validatorException.getMessage());
//            responseData.setCode(500);
//            return responseData;
//        }
//        responseData.setCode(-1);
//
//        return responseData;
//    }
}
