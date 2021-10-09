/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ProxyHandler implements InvocationHandler {

    private Target target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("动态代理对象Begin");
        Object invokeResult = method.invoke(target, args);
        log.info("动态代理对象End");
        return invokeResult;
    }
}
