/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
@Slf4j
public class NacosSameClusterWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        try {
            String clusterName = nacosDiscoveryProperties.getClusterName();
            // .var
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            // 获取服务名称
            String name = loadBalancer.getName();
            // 服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

            // 获取该服务配置的所有健康实例
            List<Instance> instanceList = namingService.selectInstances(name, true);

            List instanceToBeChosen = null;
            List<Instance> sameClusterInstanceList = instanceList.stream()
                    .filter(instance -> {
                        return Objects.equals(instance.getClusterName(), clusterName);
                    })
                    .collect(Collectors.toList());
            if (CollectionUtils.isEmpty(sameClusterInstanceList)) {
                instanceToBeChosen = instanceList;
                // log 警告
            } else {
                instanceToBeChosen = sameClusterInstanceList;
            }
            Instance hostByRandomWeight = ExternalBalancer.getHostByRandomWeight2(instanceToBeChosen);

            return new NacosServer(hostByRandomWeight);
        } catch (NacosException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}

class ExternalBalancer extends Balancer {

    // 级别提升
    public static Instance getHostByRandomWeight2(List<Instance> hosts) {
        return getHostByRandomWeight(hosts);
    }
}