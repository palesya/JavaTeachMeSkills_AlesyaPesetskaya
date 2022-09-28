package com.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        CinemaService service = new HorrorServiceImpl();
        System.out.println(service.getFilm());

        Object obj = Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{CinemaService.class},
                new CinemaInvocationHandler());
        String film = ((CinemaService) obj).getFilm();
        System.out.println(film);
    }
}
