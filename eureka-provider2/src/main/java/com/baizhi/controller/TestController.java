package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test1")
    public String testProvider(String name){
        return "xixixi 8764  :"+name;
    }

    @RequestMapping("/test2")
    public String testFeign(String name,String pwd,Integer age){
        return "xixixi 8764  :"+name+" "+pwd+" "+age;
    }

    @RequestMapping("/testFeignObj")
    public User testFeignObj(@RequestBody User user){
        user.setAge(15);
        return user;
    }
}
