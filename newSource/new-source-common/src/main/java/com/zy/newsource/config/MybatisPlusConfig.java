/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/12/23  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zy.newsource.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.zy.newsource.support.org.n3r.idworker.Sid;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2020-12-23
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public String test() {
        System.out.println("扫描到，并且启动了");
        return "success;";
    }

    // Id生成器
    @Bean
    public Sid sid() {
        return new Sid();
    }

//    @Bean
//    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
//        return p3lusProperties -> plusProperties.getGlobalConfig().setIdentifierGenerator(new IdentifierGenerator() {
//            @Override
//            public Long nextId(Object entity) {
//                Date date = new Date();
//                return date.getTime();
//            }
//
//            @Override
//            public String nextUUID(Object entity) {
//                return IdWorker.get32UUID();
//            }
//        });
//    }

    @Bean
    public IdentifierGenerator idGenerator() {
        return new IdentifierGenerator() {
            @Override
            public Long nextId(Object entity) {
                Date date = new Date();
                return date.getTime();
            }

            @Override
            public String nextUUID(Object entity) {
                return IdWorker.get32UUID();
            }
        };
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                LocalDateTime time = LocalDateTime.now();
                this.strictInsertFill(metaObject, "createdTime", LocalDateTime.class, time);
                this.strictInsertFill(metaObject, "updatedTime", LocalDateTime.class, time);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                LocalDateTime time = LocalDateTime.now();
                this.strictInsertFill(metaObject, "updatedTime", LocalDateTime.class, time);
            }
        };
    }
}
