package com.tms.homework_40.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private String name;
    private String breed;
    private Integer age;

}
