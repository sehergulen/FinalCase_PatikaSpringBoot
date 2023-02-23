package com.credit.approval.app.dto.output;

import com.credit.approval.app.model.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class CreditOutputDto{
    @ApiModelProperty(value = "credit limit of customer", dataType = "double", example = "20000")
    private double creditLimit;
    @ApiModelProperty(value = "approved status of customer", dataType = "boolean", example = "true")
    private boolean approved;
    @ApiModelProperty(value = "name of customer", dataType = "String", example = "seher")
    private String name;
    @ApiModelProperty(value = "surname of customer", dataType = "String", example = "gulen")
    private String surname;

}
