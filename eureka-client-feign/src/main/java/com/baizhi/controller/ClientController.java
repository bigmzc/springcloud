package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.feign.FeignTest;
import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
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

    @Autowired
    FeignTest feignTest;

    @RequestMapping("/test1")
    public String test(String name){
        String template = restTemplate.getForObject("http://EUREKA-PROVIDER/test/test?name=" + name, String.class);
        return template;
    }

    @RequestMapping("/feign1")
    public String testFeign(String name,String pwd,Integer age){
        String s = feignTest.testFeign(name, pwd, age);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/feignObj")
    public User testFeignObj(User user){
        User user1 = feignTest.testFeignObj(user);
        user1.setPassword("123456");
        System.out.println(user1);
        return user1;
    }

}
