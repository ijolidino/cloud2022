package com.cloud2002.controller;

import com.cloud2002.entity.CommonResult;
import com.cloud2002.entity.Payment;
import com.cloud2002.entity.Person;
import com.cloud2002.service.PaymentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Value("${server.port}")
    private String port;
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
            return new CommonResult(200,"查询成功为8002",payment);
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

    public static <T> T getMappingPo(Class<T> classz, Object[] objs) throws Exception {
        Field[]  fields = classz.getDeclaredFields();
        Object object = classz.newInstance();
        int length = objs.length;

        for(Field fild : fields ) {
            String typeStr = fild.getType().getSimpleName().toLowerCase();
            Annotation[] annos = fild.getAnnotations();

            if(annos.length > 0) {
                for(Annotation anno : annos ) {
                    if(("BOIndex".equals(anno.annotationType().getSimpleName()))) {
                        BOIndex myAmoncation = (BOIndex) anno;
                        int index = myAmoncation.index();

                        if(index < length) {
                            fild.setAccessible(true);

                            if("double".equals(typeStr)) {
                                fild.set(object, Double.valueOf(objs[index] ==null? "0" : objs[index].toString()));
                            }else if("int".equals(typeStr) || "integer".equals(typeStr)) {
                                fild.set(object, Integer.valueOf(objs[index] ==null? "0" : objs[index].toString()));
                            }else if("float".equals(typeStr)) {
                                fild.set(object, Float.valueOf(objs[index] ==null? "0" : objs[index].toString()));
                            }else if("long".equals(typeStr)) {
                                fild.set(object, Long.valueOf(objs[index] ==null? "0" : objs[index].toString()));
                            }else if("bigdecimal".equals(typeStr)) {
                                fild.set(object, new BigDecimal(objs[index] ==null? "0" : objs[index].toString()));
                            }else {
                                fild.set(object, objs[index]);
                            }
                        }
                    }
                }
            }
        }

        return (T)object;
    }

    public static void main(String[] args) throws IOException {
        writeJackonFile();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = objectMapper.readValue(new File("D:\\JavaTestFile\\JacksonFile.txt"), new TypeReference<List<Person>>() {
        });
        System.out.println(people.toString());
    }

    private static void writeJackonFile() throws IOException {
        List<Person> peoples = new ArrayList<Person>();
        for (int i=0;i<10;i++){
            Person person = new Person("张珊", i, "你好");
            peoples.add(person);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("D:\\JavaTestFile\\JacksonFile.txt"),peoples);
    }
}
