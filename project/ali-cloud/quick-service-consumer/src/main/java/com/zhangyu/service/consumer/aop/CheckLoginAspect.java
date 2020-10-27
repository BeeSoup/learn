/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/21  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能说明:
 * 切面
 *
 * @author zhang
 * @since 2020/10/21
 */
@Aspect
@Component
public class CheckLoginAspect {

    @Around("@annotation(com.zhangyu.service.consumer.annotation.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) {
        // 获取token
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequest = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequest.getRequest();
//        request.getHeader()

        return null;
    }


}
