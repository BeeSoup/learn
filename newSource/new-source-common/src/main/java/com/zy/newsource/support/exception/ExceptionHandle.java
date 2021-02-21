package com.zy.newsource.support.exception;

import com.zy.newsource.support.util.ResponseJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/21
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseJSONResult<Object> exceptionMapper(Exception e) {
        ResponseJSONResult result = ResponseJSONResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        try {
            // 业务类异常，封装，不记录
            if (e instanceof BaseBussException) {
//                String errorCode = ((BaseBizException) e).getErrorCode();
//                String errorMsg = ((BaseBizException) e).getErrorMessage();
//                if (StringUtils.isNotBlank(errorCode)) {
//                    result.setErrorCode(errorCode);
//                    if (StringUtils.isNotBlank(errorMsg)) {
//                        result.setErrorMessage(errorMsg);
//                    } else if (StringUtils.isNotBlank(ErrorCodeContainer.getErrorMessage(errorCode))) {
//                        result.setErrorMessage(ErrorCodeContainer.getErrorMessage(errorCode));
//                    } else {
//                        result.setErrorMessage(errorCode);
//                    }
//                } else {
//                    result = ResponseJSONResult.errorMsg(AspectConstant.FAIL_CODE, e.getMessage());
//                }
                //校验异常则将错误信息提示给调用方
//            }
//            else if (e instanceof ConstraintViolationException) {
//                result = ResponseJSONResult.errorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), ((ConstraintViolationException)e).getConstraintViolations().stream()
//                        .map(ConstraintViolation::getMessage)
//                        .collect(Collectors.joining(",")));
                result = ResponseJSONResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            } else {
                // 调整日志输出
                log.error(e.getMessage());
                result = ResponseJSONResult.errorMsg(e.getMessage());
            }
        } catch (Exception ex) {
            log.error("返回封装类失败", ex);
            result = ResponseJSONResult.errorMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        e.printStackTrace();
        return result;
    }
}
