package com.dernekapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {

    private String status;
    private String message;
    private Date date;
    private String path;

    private Map<String,String> validationErrors;
}
