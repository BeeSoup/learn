/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/3/30  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zy.newsource.config.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-03-30
 */
@Component
public class MyJob {

    /**
     * https://cron.qqe2.com/
     * 无集群，有时间差 读数据库，查询，影响数据库
     *  MQ 的延时队列
     */
    // "0 * * * * MON-FRI"
    @Scheduled(cron = "")
    public void autoDeal() {

    }
}
