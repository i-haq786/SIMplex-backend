package com.inzi.sim_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String description;
    private String message;

}
