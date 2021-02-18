package com.zhang.learnSource.bootstrap.conditional;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * TODO...
 *
 * @author zy
 * @since 2021/2/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * Alias for {@link #name()}.
     * @return the names
     */
    String value() default "";

    String name() default "";

}
