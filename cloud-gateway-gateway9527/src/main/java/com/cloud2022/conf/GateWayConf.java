package com.cloud2022.conf;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

/**
 * @program: cloud2022
 * @description: 网关配置
 * @author: Fuwen
 * @create: 2022-07-03 23:04
 **/
@Configuration
public class GateWayConf {
@Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("tanfuwen",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();


    }
}
