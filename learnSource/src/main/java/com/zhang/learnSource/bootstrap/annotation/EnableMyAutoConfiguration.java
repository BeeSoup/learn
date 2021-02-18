package com.zhang.learnSource.bootstrap.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义的自动装配
 *
 * @author zy
 * @since 2021/2/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
