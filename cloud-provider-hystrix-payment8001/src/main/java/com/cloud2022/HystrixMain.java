package com.cloud2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2022
 * @description: 主启动类
 * @author: Fuwen
 * @create: 2022-06-27 20:03
 **/
@SpringBootApplication
@EnableEurekaClient
public class HystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain.class,args);
    }
}
