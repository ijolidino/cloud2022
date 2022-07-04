package com.cloud2002.service.Impl;

import com.cloud2002.dao.PaymentDAO;
import com.cloud2002.entity.Payment;
import com.cloud2002.service.PaymentService;
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
    private PaymentDAO paymentDAO;
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDAO.getById(id);
    }
}
