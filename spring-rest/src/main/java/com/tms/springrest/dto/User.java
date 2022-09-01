package com.tms.springrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends RepresentationModel<User> {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private SEX sex;
    private Date date;
}
