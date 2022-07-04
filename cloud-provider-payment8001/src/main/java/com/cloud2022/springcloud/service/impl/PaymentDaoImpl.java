package com.cloud2022.springcloud.service.impl;

import com.cloud2022.entity.Payment;
import com.cloud2022.springcloud.service.PaymentDao;

/**
 * @program: cloud2022
 * @description: 支付实现类
 * @author: Fuwen
 * @create: 2022-06-23 21:58
 **/
public class PaymentDaoImpl implements PaymentDao {
    @Override
    public int create(Payment payment) {
        return 0;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return null;
    }
}
