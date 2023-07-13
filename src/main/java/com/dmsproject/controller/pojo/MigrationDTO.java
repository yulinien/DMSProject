package com.dmsproject.controller.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MigrationDTO {

    @JsonProperty("status")
    private int status;
    @JsonProperty("result")
    private String result;
}
