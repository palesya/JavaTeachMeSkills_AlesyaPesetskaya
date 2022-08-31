package com.tms.homework_40.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CatDTO {
    private Long id;
    private String name;
    private String breed;
    private Integer age;
}

