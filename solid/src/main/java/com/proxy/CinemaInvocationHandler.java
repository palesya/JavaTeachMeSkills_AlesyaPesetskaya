package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CinemaInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().contains("getFilm")){
            return "telepuziki";
        }
        return method.invoke(proxy, args);
    }

}
