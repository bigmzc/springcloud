package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/query")
public class CliController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(String name){
        String template = restTemplate.getForObject("http://EUREKA-PROVIDER/test/test?name=" + name, String.class);
        return template;
    }
}
