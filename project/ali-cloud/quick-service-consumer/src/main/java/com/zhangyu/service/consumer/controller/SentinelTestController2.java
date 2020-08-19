/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.zhangyu.service.consumer.exception.sentinel.BlockHandle;
import com.zhangyu.service.consumer.exception.sentinel.FallbackHandle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/18
 */
@Slf4j
@RestController
public class SentinelTestController2 {


    @GetMapping(value = "test-ab2")
    @SentinelResource("testAB3")
    public String testAB(@RequestParam(required = false) String a, @RequestParam(required = false) String b) {
        return a + " " + b;
    }

    @GetMapping(value = "test-add2")
    @SentinelResource("testAB4")
    public String testAB() {
        this.initFlowQpsRule();
        return "success";
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


    // 原生Sentinel API
    @GetMapping(value = "test-sentinel-api2")
    @SentinelResource(value = "test-sentinel-api2",
            blockHandler = "blockHandler",
            blockHandlerClass = {
                    BlockHandle.class
            },
            fallbackClass = {
                    FallbackHandle.class
            },
            fallback = "fallback"
    )// 不支持来源
    public String testSentinelAPI(@RequestParam String a) {

        if (StringUtils.isBlank(a)) {
            throw new IllegalArgumentException("参数非法！");
        }
        return a;
    }


}
