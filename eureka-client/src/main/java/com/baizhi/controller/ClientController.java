package com.baizhi.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/query")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "hystrixFallback")
    @RequestMapping("/test")
    public String test(String name){
        String template = restTemplate.getForObject("http://EUREKA-PROVIDER/test/test1?name=" + name, String.class);
        return template;
    }

    //发生断路时调用的方法
    public String hystrixFallback(String name){
        return "hystrixFallback info "+name;
    }

    @RequestMapping("/load")
    public void loadBalanceTest(String name){

        IRule iRule; //该接口管控ribbon负载均衡策略实现类
        ServiceInstance instance = loadBalancerClient.choose("EUREKA-PROVIDER");
        String host = instance.getHost();
        int port = instance.getPort();
        URI uri = instance.getUri();
        System.out.println(host);
        System.out.println(port);
        System.out.println(uri);
    }
}
