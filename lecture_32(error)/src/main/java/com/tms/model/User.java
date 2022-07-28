package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "please fill login")
    private String login;
    @NotBlank(message = "please fill password")
    @Size(min = 5,max = 20, message = "password should be from 5 to 20")
    private String password;
}
