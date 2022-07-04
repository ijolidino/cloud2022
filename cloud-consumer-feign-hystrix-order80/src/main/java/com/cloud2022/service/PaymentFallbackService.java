package com.cloud2022.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2022
 * @description:
 * @author: Fuwen
 * @create: 2022-06-29 19:23
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
