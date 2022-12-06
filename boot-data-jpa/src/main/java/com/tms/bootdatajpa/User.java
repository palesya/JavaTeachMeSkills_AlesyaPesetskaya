package com.tms.bootdatajpa;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    Integer id;
    String name;
    String address;
    Integer age;

}
