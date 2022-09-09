package com.lecture_43.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private Integer age;
    private boolean isAdmin;

    public String allInfo() {
        return name + " : " + age;
    }

}
