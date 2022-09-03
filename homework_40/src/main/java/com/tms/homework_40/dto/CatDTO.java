package com.tms.homework_40.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CatDTO extends RepresentationModel<CatDTO> {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String breed;
    @NotNull
    private Integer age;
}

