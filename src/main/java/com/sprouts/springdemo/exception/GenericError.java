package com.sprouts.springdemo.exception;

import com.sprouts.springdemo.constants.ErrorType;
import lombok.Data;

@Data
public class GenericError {

    private String errorType;
    private String errorMsg;

    public GenericError(ErrorType errorType, String errorMsg) {
        this.errorType = errorType.name();
        this.errorMsg = errorMsg;
    }
}
