package com.zhang.learnSource.bootstrap.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * TODO...
 *
 * @author zy
 * @since 2021/2/10
 */
public class OnSystemPropertyCondition implements Condition {
//    @Override
//    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        return null;
//    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 获取所有的annotation 的配置
//        Map<String, Object> au = metadata.getAllAnnotationAttributes(OnSystemPropertyCondition.class.getName());

        Map<String, Object> annotationAttributes = Optional.ofNullable(metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName()))
                .orElse(new HashMap<>());

        // 系统属性名称
        String systemPropertiesName = String.valueOf(annotationAttributes.get("name"));

        // 系统属性值
        String systemPropertiesValue = String.valueOf(annotationAttributes.get("value"));

        // 获取系统配置的
        String property = System.getProperty(systemPropertiesName);


        // 通过配置，用来条件装配Bean 是否装配
        return Objects.equals(systemPropertiesValue, property);
    }
}
