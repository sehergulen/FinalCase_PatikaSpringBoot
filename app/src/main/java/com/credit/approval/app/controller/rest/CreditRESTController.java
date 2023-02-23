package com.credit.approval.app.controller.rest;

import com.credit.approval.app.dto.input.CreditInputDto;
import com.credit.approval.app.dto.input.UpdateCustomerCreditPointInputDto;
import com.credit.approval.app.dto.output.CreditOutputDto;
import com.credit.approval.app.dto.output.CustomerOutputDto;
import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.service.CreditService;
import com.credit.approval.app.service.CustomerService;
import com.credit.approval.app.utils.DtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/credit")
public class CreditRESTController {
    @Autowired
    CreditService creditService;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(value = "/add")
    CreditOutputDto addCredit(@RequestBody CreditInputDto creditInputDto) {
        log.info("addCredit called with parameters: {}", creditInputDto);
        Credit credit=creditService.addCredit(creditInputDto.getTc(),creditInputDto.getDeposit());
        CreditOutputDto creditOutputDto = dtoMapper.convertCreditToCreditOutputDto(credit);
        return creditOutputDto;
    }
    @GetMapping(value = "/list/{tc}/{birthdate}")
    List<CreditOutputDto> listCredit(@PathVariable long tc, @PathVariable String birthdate) {
        log.info("listCredit called with tc: {} birthdate: {} ", tc,birthdate);
        List<Credit> creditList=creditService.listCreditByTcAndBirthdate(tc,birthdate);
        List<CreditOutputDto> creditOutputDtoList=new ArrayList<>();
        for (Credit credit:creditList) {
            CreditOutputDto creditOutputDto = dtoMapper.convertCreditToCreditOutputDto(credit);
            creditOutputDtoList.add(creditOutputDto);
        }
        return creditOutputDtoList;
    }
    @GetMapping(value = "/list")
    List<CreditOutputDto> listCredit() {
        log.info("listCredit called.");
        List<CreditOutputDto> creditOutputDtoList=new ArrayList<>();
        for (Credit credit: creditService.findAllCredits()) {
            CreditOutputDto creditOutputDto=dtoMapper.convertCreditToCreditOutputDto(credit);
            creditOutputDtoList.add(creditOutputDto);
        }
        return creditOutputDtoList;
    }
}
