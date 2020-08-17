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
public class NacosSameClusterWeightedVersionRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        try {
            String clusterName = nacosDiscoveryProperties.getClusterName();
            // 版本
            String version = nacosDiscoveryProperties.getMetadata().get("version");

            // 允许的target-version

            // .var
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            // 获取服务名称
            String name = loadBalancer.getName();
            // 服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

            // 获取该服务配置的所有健康实例
            List<Instance> instanceList = namingService.selectInstances(name, true);

            // 若同集群下 同version 的实例是空，如何处理！ --
            List instanceToBeChosen = null;
            List<Instance> sameClusterInstanceList = instanceList.stream()
                    // 过滤同集群
                    .filter(instance -> {
                        return Objects.equals(instance.getClusterName(), clusterName);
                    })
                    // 过滤版本
                    .filter(instance -> {
                        return Objects.equals(instance.getMetadata().get("version"), version);
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
