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
    @NotEmpty(message = "{empty_name}")
    @Size(min = 1,max = 20, message = "{size_name}")
    private String name;
    @NotEmpty(message = "{empty_author}")
    private String author;
}
