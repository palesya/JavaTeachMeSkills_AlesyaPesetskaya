package com.tms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID uuid;
    private String name;
    private Sex sex;
    private long salary;

    public enum Sex {
        MAN, WOMAN
    }

    public User(String name, Sex sex, long salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        uuid=UUID.randomUUID();
    }
}
