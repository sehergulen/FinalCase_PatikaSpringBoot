package com.credit.approval.app.dto.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

public class CustomerInputDto {
    @ApiModelProperty(value = "name of customer", dataType = "String", example = "seher")
    private String name;
    @ApiModelProperty(value = "surname of customer", dataType = "String", example = "gulen")
    private String surname;
    @ApiModelProperty(value = "tc number of customer", dataType = "Long", example = "111111")
    private long tc;
    @ApiModelProperty(value = "birthdate of customer", dataType = "String", example = "04-04-1997")
    private String birthdate;
    @ApiModelProperty(value = "phone number of customer", dataType = "String", example = "5555555")
    private String phoneNumber;
    @ApiModelProperty(value = "income of customer", dataType = "double", example = "25000")
    private double income;
    @ApiModelProperty(value = "credit point of customer", dataType = "Long", example = "750")
    private long creditPoint;


}
