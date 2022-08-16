package com.example.lecture_35.dto;

import com.example.lecture_35.model.Address;
import com.example.lecture_35.model.Pet;
import com.example.lecture_35.model.Phone;
import com.example.lecture_35.model.SEX;

import java.util.List;

public class UserDTO {

    private String login;
    private String password;
    private SEX sex;
    private List<Address> address;
    private Phone phone;
    List<Pet> pets;
}
