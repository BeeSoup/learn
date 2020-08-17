/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
public class ConsumeFeignClientConfiguration {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
