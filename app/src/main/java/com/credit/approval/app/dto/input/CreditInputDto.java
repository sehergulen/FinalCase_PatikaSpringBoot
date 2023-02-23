package com.credit.approval.app.dto.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditInputDto {
    @ApiModelProperty(value = "tc number of customer", dataType = "Long", example = "seher")
    private long tc;
    @ApiModelProperty(value = "deposit value of a candidate credit", dataType = "Double", example = "0")
    private double deposit;
}
