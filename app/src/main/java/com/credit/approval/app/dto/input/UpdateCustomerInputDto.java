package com.credit.approval.app.dto.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerInputDto {
    @ApiModelProperty(value = "tc number of customer", dataType = "Long", example = "seher")
    private long tc;
    @ApiModelProperty(value = "income of customer", dataType = "Double", example = "25000")
    private double income;
}
