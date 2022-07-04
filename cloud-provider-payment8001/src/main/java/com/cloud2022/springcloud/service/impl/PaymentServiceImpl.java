package com.cloud2022.springcloud.service.impl;
import com.cloud2022.entity.Payment;
import com.cloud2022.springcloud.service.PaymentDao;
import com.cloud2022.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: com.blackmagic.springcloud
 * @description: 支付
 * @author: Fuwen
 * @create: 2021-10-27 18:45
 **/
@Component
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDAO;
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
