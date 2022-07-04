package com.cloud2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2022
 * @description:
 * @author: Fuwen
 * @create: 2022-06-26 22:18
 **/
@SpringBootApplication
@EnableFeignClients
public class FeignMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain.class,args);
    }
}
