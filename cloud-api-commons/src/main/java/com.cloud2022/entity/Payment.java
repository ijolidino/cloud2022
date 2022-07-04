package com.cloud2022.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: com.blackmagic.springcloud
 * @description: 支付类
 * @author: Fuwen
 * @create: 2021-10-26 23:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
