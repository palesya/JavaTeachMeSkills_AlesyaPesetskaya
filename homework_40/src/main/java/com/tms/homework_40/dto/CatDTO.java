package com.tms.homework_40.dto;

import com.tms.homework_40.web.CatController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import javax.validation.constraints.NotNull;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public void addLink(){
        Link link = WebMvcLinkBuilder.linkTo(methodOn(CatController.class).getById(id)).withSelfRel();
        add(link);
    }
}

