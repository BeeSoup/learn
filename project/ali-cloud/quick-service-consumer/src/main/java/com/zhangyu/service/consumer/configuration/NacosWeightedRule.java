/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/14  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/14
 */
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        // 读取配置文件，并初始化
    }

    @Override
    public Server choose(Object key) {
        try {
            // .var
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();

            // 服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

            // nacos client自动基于权重给予实例
            Instance instance = namingService.selectOneHealthyInstance(loadBalancer.getName());

            return new NacosServer(instance);

        } catch (NacosException e) {
            return null;
        }
    }
}
