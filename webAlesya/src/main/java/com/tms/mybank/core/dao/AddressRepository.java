package com.tms.mybank.core.dao;

import com.tms.mybank.core.entity.Address;

public class AddressRepository {

    Address save(Address address){
        System.out.println("save address");
        return address;
    }
}
