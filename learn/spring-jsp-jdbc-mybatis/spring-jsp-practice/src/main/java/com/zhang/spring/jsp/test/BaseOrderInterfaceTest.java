package com.zhang.spring.jsp.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(value = {BaseOrderInterfaceEntity1.class})//无效
public class BaseOrderInterfaceTest implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, BaseOrderInterface> baseFactory = BeanFactoryUtils.beansOfTypeIncludingAncestors(this.applicationContext, BaseOrderInterface.class,
                true, false);
        Collection<BaseOrderInterface> values = baseFactory.values();
        List<BaseOrderInterface> baseOrderInterfaces = new ArrayList<>(values);
        AnnotationAwareOrderComparator.sort(baseOrderInterfaces);
        for (BaseOrderInterface base : baseOrderInterfaces) {
            base.run();
        }

    }
}
