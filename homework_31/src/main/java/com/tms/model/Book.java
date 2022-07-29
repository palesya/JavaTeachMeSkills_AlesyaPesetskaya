package com.tms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotEmpty(message = "Name can't be blank")
    @Size(min = 1,max = 20, message = "Size should be from 1 to 20 symbols")
    private String name;
    @NotEmpty(message = "Author can't be blank")
    private String author;
}
