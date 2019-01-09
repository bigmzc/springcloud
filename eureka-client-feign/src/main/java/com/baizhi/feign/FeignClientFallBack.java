package com.baizhi.feign;

import com.baizhi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBack implements FeignTest {
    @Override
    public String testFeign(String name, String pwd, Integer age) {

        return "fallback method invoked";
    }

    //当testFeignObj断路时，返回该方法
    @Override
    public User testFeignObj(User user) {
        User user1 = new User(null,null,-1);
        return user1;
    }
}
