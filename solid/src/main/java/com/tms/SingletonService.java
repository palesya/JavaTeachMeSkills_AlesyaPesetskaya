package com.tms;

public class SingletonService {

    private static SingletonService INSTANCE;

    private SingletonService() {
        System.out.println("created");
    }

    public static SingletonService getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (SingletonService.class) {
            if (INSTANCE == null) {
                INSTANCE = new SingletonService();
            }
        }
        return INSTANCE;
    }
}
