package com.zhang.learnSource.bootstrap;

import com.zhang.learnSource.bootstrap.annotation.HelloWorldImportSelector;
import com.zhang.learnSource.bootstrap.conditional.ConditionalOnSystemProperty;
import com.zhang.learnSource.bootstrap.profile.ProfileTest;
import com.zhang.learnSource.bootstrap.test.TestBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;


/**
 * 功能：
 *
 * @author zy
 * @since 2021/2/9
 */
//@ComponentScan
// 以下两个注解效果相同
// @Import(HelloWorldImportSelector.class)
// @Import(TestBean.class)
// @ComponentScan(basePackages = "com.zhang.learnSource.bootstrap.profile"
@EnableAutoConfiguration
public class LearnSourceBootStrap {


//    @Bean
//    @ConditionalOnSystemProperty(name = "user.name" ,value = "zhangyu")
//    public String helloConditional() {
//        return "is conditional";
//    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(LearnSourceBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("8")
                .build()
                .run(args);

        String testBean = context.getBean("testMyBean",String.class);
        System.out.println("bean: " + testBean);

//        ProfileTest profileTest = context.getBean(ProfileTest.class);
//        profileTest.say();
//        try {
//            String helloConditional = context.getBean("helloConditional", String.class);
//            System.out.println(helloConditional);
//        } catch (NoSuchBeanDefinitionException e) {
//            // log记录一下
//            e.printStackTrace();
//        }
        // 关闭上下文
        context.close();
    }

}
