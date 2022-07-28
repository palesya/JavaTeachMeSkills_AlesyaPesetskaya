package com.tms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull(message = "Name can't be blank")
    @Size(min = 1,max = 20)
    private String name;
    @NotNull(message = "Author can't be blank")
    private String author;
}
