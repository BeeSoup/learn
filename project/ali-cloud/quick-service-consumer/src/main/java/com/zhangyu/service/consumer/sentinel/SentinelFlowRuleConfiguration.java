/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/18
 */
@Configuration
public class SentinelFlowRuleConfiguration {

    // 执行初始化即可
    @Bean
    public String addSentinelFlowRule() {
        this.initFlowQpsRule();
        return "success!";
    }

    // 配置规则
    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        // 获取是路径，资源点
        FlowRule rule = new FlowRule("hot");
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
