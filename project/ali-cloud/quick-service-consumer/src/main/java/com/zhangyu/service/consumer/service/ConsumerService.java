package com.zhangyu.service.consumer.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


public interface ConsumerService {

    List<ServiceInstance> getInstances(String serverId);
}

