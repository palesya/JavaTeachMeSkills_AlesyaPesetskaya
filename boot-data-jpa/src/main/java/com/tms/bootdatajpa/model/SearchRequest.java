package com.tms.bootdatajpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private String login;
    private String password;
    private Boolean isActive;

}
