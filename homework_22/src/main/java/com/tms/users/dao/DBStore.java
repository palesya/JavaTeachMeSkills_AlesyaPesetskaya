package com.tms.users.dao;

import com.tms.users.objects.Car;
import java.util.Map;
import java.util.TreeMap;

public class DBStore {

    private Map<Integer, Car> cars = new TreeMap<>();

    private static DBStore dbStore = null;

    private DBStore() {
    }

    public static DBStore getCarContainer() {
        if (dbStore != null) {
            return dbStore;
        } else {
            synchronized (DBStore.class) {
                if (dbStore == null) {
                    dbStore = new DBStore();
                }
            }
        }
        return dbStore;
    }

    public Map<Integer, Car> getAllCars(){
        return cars;
    }

    public Car getById(Integer id){
        return cars.get(id);
    }

}
