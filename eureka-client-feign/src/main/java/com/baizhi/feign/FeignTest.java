package com.baizhi.feign;

import com.baizhi.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "EUREKA-PROVIDER",fallback = FeignClientFallBack.class)
public interface FeignTest {
    //返回值为最终返回值
    @RequestMapping(value = "/test/test2",method = RequestMethod.GET)
    String testFeign(@RequestParam("name") String name, @RequestParam("pwd")String pwd, @RequestParam("age")Integer age);

    @RequestMapping(value = "/test/testFeignObj",method = RequestMethod.POST)
    User testFeignObj(User user);
}
