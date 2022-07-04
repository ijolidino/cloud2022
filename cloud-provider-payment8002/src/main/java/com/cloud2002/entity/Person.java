package com.cloud2002.entity;

import java.io.Serializable;

/**
 * @program: com.blackmagic.springcloud
 * @description: 人物类
 * @author: Fuwen
 * @create: 2021-12-31 12:37
 **/
public class Person implements Serializable {
    public Person() {
    }

    private String name;

    private int age;

    private String desc;

    public Person(String name, int age, String desc) {
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
