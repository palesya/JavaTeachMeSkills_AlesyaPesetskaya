package com.tms.mybank.core.dao;

import com.tms.mybank.core.entity.User;

import java.util.Collection;
import java.util.Map;

public class DBStore {

    Map<String, User> user = Map.of("1", new User("sdd"), "2", new User("sds"));

    private static DBStore dbStore = null;

    private DBStore() {
    }

    public static DBStore getDBStore() {
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

    public Collection<User> getAllUsers() {
        return user.values();
    }
}
