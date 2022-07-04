package com.cloud2022.springcloud.service;

import com.cloud2022.entity.Payment;

/**
 * @program: com.blackmagic.springcloud
 * @description: 支付
 * @author: Fuwen
 * @create: 2021-10-27 18:44
 **/

public interface PaymentService {
    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 通过id获取支付信息
     * @param id
     * @return
     */
    Payment getById(Long id);
}
