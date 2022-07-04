package com.cloud2002.dao;

import com.cloud2002.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: com.blackmagic.springcloud
 * @description: 支付主启动类
 * @author: Fuwen
 * @create: 2021-10-26 23:38
 **/
@Mapper
public interface PaymentDAO {
    /**
     * 创建
     * @param payment
     */
    int create(Payment payment);

    /**
     * 通过id获取支付信息
     * @param id
     * @return
     */
    Payment getById(@Param("id") Long id);
}
