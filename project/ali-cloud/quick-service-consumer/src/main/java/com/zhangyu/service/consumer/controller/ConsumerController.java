package com.zhangyu.service.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private DiscoveryClient discoveryClient;


    @Value("${zhangyu.service.provider}")
    private String provider;

    @Resource
    RestTemplate restTemplate;

    @Resource
    RestTemplate restTemplateUnLoadBalance;

    //"http://service-provider/echo/"
    @GetMapping("/consumer/{value}")
    public String consumer(@PathVariable String value) {
        String url = "http://" + provider + "/echo/" + value;
        log.info("url地址： \t {}", url);
        String urlIP = "http://127.0.0.1:8009/echo/9";
        //属于key value参数，不属于请求路径，所有无法匹配
        //
        String response = this.restTemplate.getForObject(url, String.class);
//        String response = restTemplateUnLoadBalance.getForObject(urlIP, String.class, value);
        String localBalanceURI = this.getInstance().stream()
                .map((serviceInstance) -> {
                    return serviceInstance.getUri() + "/echo/" + value;
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("没有数据"));

        //        String response = restTemplateUnLoadBalance.getForObject(localBalanceURI, String.class, value);
        log.info("response： \t {}", response);
        return response;
    }

    /**
     * 有返回结果 说明是能感知到 服务Ip
     *
     * @return
     */
    @GetMapping(value = "/consumer/service")
    public List<ServiceInstance> getInstance() {
        return this.discoveryClient.getInstances("quick-service-provider");
    }
}
