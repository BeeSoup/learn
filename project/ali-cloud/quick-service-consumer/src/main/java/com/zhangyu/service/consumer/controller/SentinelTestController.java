/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
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
public class SentinelTestController {


    @GetMapping(value = "test-ab")
    @SentinelResource("testAB")
    public String testAB(@RequestParam(required = false) String a, @RequestParam(required = false) String b) {
        return a + " " + b;
    }

    @GetMapping(value = "test-add")
    @SentinelResource("testAB2")
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
    @GetMapping(value = "test-sentinel-api")
    public String testSentinelAPI(@RequestParam String a) {
        // 唯一名即可
        String resourceName = "test-sentinel-api";
        // 配置来源
        ContextUtil.enter(resourceName,"other-service");
        // 定义一个被sentinel 保护的资源
        Entry entry = null;
        try {
            // 定义资源，保护资源，监控
            entry = SphU.entry(resourceName);
            if (StringUtils.isBlank(a)) {
                throw new IllegalArgumentException("参数非法！");
            }
            // 书写业务逻辑
            return a;
        } catch (BlockException e) {
            // 对于保护的资源如果 限流或者降级了
            log.warn("呵呵");
            return "呵呵";
        } catch (IllegalArgumentException e2) {
            // 捕获异常数，用于统计
            Tracer.trace(e2);
            return "参数非法";
        }
        finally {
            if (entry != null) {
                // 退出entry
                entry.exit();
            }
            ContextUtil.exit();
        }
    }
}
