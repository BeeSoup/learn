package com.zhang.learnSource.bootstrap.annotation;

import com.zhang.learnSource.bootstrap.test.TestBean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld ${@link ImportSelector}
 *
 * @author zy
 * @since 2021/2/9
 */
public class HelloWorldImportSelector implements ImportSelector {

    public HelloWorldImportSelector() {
        System.out.println("HelloWorldImportSelector is start");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{TestBean.class.getName()};
    }
}
