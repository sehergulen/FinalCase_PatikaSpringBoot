package com.credit.approval.app.dto.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerCreditPointInputDto {
    @ApiModelProperty(value = "tc number of customer", dataType = "Long", example = "seher")
    private long tc;
    @ApiModelProperty(value = "credit point of customer", dataType = "Long", example = "750")
    private long creditPoint;
}
