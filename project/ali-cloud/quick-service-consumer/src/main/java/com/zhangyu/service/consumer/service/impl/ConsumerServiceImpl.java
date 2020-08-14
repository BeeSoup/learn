package com.zhangyu.service.consumer.service.impl;

import com.zhangyu.service.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/14
 */
@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    @Resource
    private DiscoveryClient discoveryClient;

    @Override
    public List<ServiceInstance> getInstances(String serverId) {
        return this.discoveryClient.getInstances(serverId);
    }
}
