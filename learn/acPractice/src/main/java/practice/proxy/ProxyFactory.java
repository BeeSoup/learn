/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */
public class ProxyFactory<T> {


    /**
     * 代理class
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Target> Target getInstant(Class<T> clazz) {
        Target proxyInstance = null;
        try {
            T instance = clazz.newInstance();
            ProxyHandler handler = new ProxyHandler(instance);
            proxyInstance = (Target) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
//            proxyInstance.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return proxyInstance;
    }

    /**
     * 代理匿名内酯类
     *
     * @return
     */
    public static <T extends Target> Target getInstant(Target instance) {
        Target proxyInstance = null;
        try {
            ProxyHandler handler = new ProxyHandler(instance);
            proxyInstance = (Target) Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), handler);
//            proxyInstance.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxyInstance;
    }

    public static <T> T getCGInstant(Class<T> clazz) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);

        CGLIBMethodHandler cglibMethodHandler = new CGLIBMethodHandler();

        enhancer.setCallback(cglibMethodHandler);
        T o = (T) enhancer.create();
        return o;
    }
}
