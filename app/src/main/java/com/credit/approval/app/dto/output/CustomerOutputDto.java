package com.credit.approval.app.dto.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CustomerOutputDto {
    @ApiModelProperty(value = "id of customer", dataType = "Long", example = "1")
    private long id;
    @ApiModelProperty(value = "name of customer", dataType = "String", example = "seher")
    private String name;
    @ApiModelProperty(value = "surname of customer", dataType = "String", example = "gulen")
    private String surname;
    @ApiModelProperty(value = "tc number of customer", dataType = "Long", example = "11111")
    private long tc;
    @ApiModelProperty(value = "birthdate of customer", dataType = "String", example = "04-04-1997")
    private String birthdate;
    @ApiModelProperty(value = "phone number of customer", dataType = "String", example = "55555")
    private String phoneNumber;
    @ApiModelProperty(value = "income of customer", dataType = "double", example = "25000")
    private double income;
    @ApiModelProperty(value = "credit point of customer", dataType = "Long", example = "20000")
    private long creditPoint;

}
