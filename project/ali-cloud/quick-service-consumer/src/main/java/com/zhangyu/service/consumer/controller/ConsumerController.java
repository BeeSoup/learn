package com.zhangyu.service.consumer.controller;

import com.zhangyu.service.consumer.entity.ResponseData;
import com.zhangyu.service.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ConsumerController {


    @Autowired
    private ConsumerService consumerService;


    @Value("${zhangyu.service.provider}")
    private String provider;

    /**
     * ribbon 负载均衡
     */
    @Resource
    RestTemplate restTemplate;

    /**
     * 未加负载均衡的
     */
    @Resource
    RestTemplate restTemplateUnLoadBalance;

    //"http://service-provider/echo/"
    @GetMapping("/consumer/{value}")
    public ResponseData consumer(@PathVariable String value) {
        // String serverId = "quick-service-provider";
        String url = "http://" + provider + "/echo/" + value;
        log.info("url地址： \t {}", url);
        // 属于key value参数，不属于请求路径，所有无法匹配
        ResponseData response = this.restTemplate.getForObject(url, ResponseData.class);
        List<ServiceInstance> instances = this.consumerService.getInstances(provider);
        String localBalanceURI = instances.stream()
                .map((serviceInstance) -> {
                    return serviceInstance.getUri() + "/echo/" + value;
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("没有数据"));

//        ResponseData response = restTemplateUnLoadBalance.getForObject(localBalanceURI, ResponseData.class);
        log.info("response： \t {}", response);
        return response;
    }

    /**
     * 有返回结果 说明是能感知到 服务Ip
     *
     * @return
     */
    @GetMapping(value = "/consumer/service")
    public ResponseData getInstance() {
        ResponseData responseData = new ResponseData();
        responseData.setData(consumerService.getInstances(provider));
        return responseData;
    }
}
