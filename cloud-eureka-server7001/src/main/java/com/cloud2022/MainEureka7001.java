package com.cloud2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: cloud2022
 * @description: eureka注册中心
 * @author: Fuwen
 * @create: 2022-06-24 23:25
 **/
@SpringBootApplication
@EnableEurekaServer
public class MainEureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(MainEureka7001.class,args);
    }
}
