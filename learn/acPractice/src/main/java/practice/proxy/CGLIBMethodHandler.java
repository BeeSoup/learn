/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */
@Slf4j
public class CGLIBMethodHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Cglib代理对象Begin");
        Object invokeResult = methodProxy.invokeSuper(o, objects);
        log.info("Cglib代理对象End");
        return invokeResult;
    }
}
