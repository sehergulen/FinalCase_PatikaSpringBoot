package com.credit.approval.app.dto.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponseDto {
    @ApiModelProperty(value = "message for exception", dataType = "Long", example = "Customer is already defined at database with ..")
    private String message;
    @ApiModelProperty(value = "status of exception", dataType = "String", example = "ERROR")
    private String status;
    @ApiModelProperty(value = "date time of exception", dataType = "LocalDateTime", example = "seher")
    private LocalDateTime dateTime;
}
