package com.baizhi.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConf {

    @Bean
    public Logger.Level getFeignConf(){
        return Logger.Level.FULL;
    }
}
