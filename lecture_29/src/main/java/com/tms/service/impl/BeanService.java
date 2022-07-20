package com.tms.service.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeanService {

    private String defaultValue;

    public BeanService(){
        System.out.println("constructor");
    }

    public void init(){
        System.out.println("init");
        System.out.println(defaultValue);
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
