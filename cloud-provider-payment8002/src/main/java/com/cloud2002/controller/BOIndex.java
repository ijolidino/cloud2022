package com.cloud2002.controller;

import java.lang.annotation.*;

/**
 * @program: com.blackmagic.springcloud
 * @description:
 * @author: Fuwen
 * @create: 2021-12-07 21:24
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public  @interface BOIndex {
    int index();
}
