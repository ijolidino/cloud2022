package com.cloud2022;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: com.blackmagic.springcloud
 * @description: 主启动类
 * @author: Fuwen
 * @create: 2021-10-29 23:43
 **/
@SpringBootApplication
@EnableEurekaServer
public class MainEureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(MainEureka7002.class,args);
    }
}
