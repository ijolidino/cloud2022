package com.cloud2022.springcloud.controller;
import com.cloud2022.entity.Payment;
import com.cloud2022.springcloud.service.PaymentService;
import com.cloud2022.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: com.blackmagic.springcloud
 * @description: 控制层
 * @author: Fuwen
 * @create: 2021-10-27 18:50
 **/
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",payment.toString());
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        if (null!=payment){
            return new CommonResult(200,"查询成功为8001",payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discoverClient(){
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            System.out.println("element:"+service);
        }
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        list.forEach(i-> log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri()));
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }
}
