package com.cloud2002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: com.blackmagic.springcloud
 * @description:
 * @author: Fuwen
 * @create: 2021-10-30 08:51
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MainPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment8002.class,args);
    }
}
