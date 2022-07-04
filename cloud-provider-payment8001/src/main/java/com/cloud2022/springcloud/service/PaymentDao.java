package com.cloud2022.springcloud.service;

import com.cloud2022.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2022
 * @description: 支付接口
 * @author: Fuwen
 * @create: 2022-06-23 21:57
 **/
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
