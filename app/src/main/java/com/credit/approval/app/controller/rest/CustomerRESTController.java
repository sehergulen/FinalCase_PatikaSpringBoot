package com.credit.approval.app.controller.rest;

import com.credit.approval.app.dto.input.CustomerInputDto;
import com.credit.approval.app.dto.input.UpdateCustomerCreditPointInputDto;
import com.credit.approval.app.dto.input.UpdateCustomerInputDto;
import com.credit.approval.app.dto.output.CustomerOutputDto;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.service.CustomerService;
import com.credit.approval.app.utils.DtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Slf4j
public class CustomerRESTController {
    @Autowired
    CustomerService customerService;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(value = "/add")
    CustomerOutputDto addCustomer(@RequestBody CustomerInputDto customerInputDto) {
        log.info("addCustomer called with parameters: {}", customerInputDto);
        Customer customer = customerService.addCustomer(
                customerInputDto.getName(),
                customerInputDto.getSurname(),
                customerInputDto.getTc(),
                customerInputDto.getBirthdate(),
                customerInputDto.getPhoneNumber(),
                customerInputDto.getIncome());
        CustomerOutputDto customerOutputDto = dtoMapper.convertCustomerToCustomerOutputDto(customer);
        return customerOutputDto;
    }

    @PostMapping(value = "/update/income")
    CustomerOutputDto updateCustomerIncome(@RequestBody UpdateCustomerInputDto updateCustomerInputDto) {
        log.info("updateCustomer called with parameters: {}", updateCustomerInputDto);
        Customer customerUpdated = customerService.updateCustomerIncome(updateCustomerInputDto.getTc(), updateCustomerInputDto.getIncome());
        CustomerOutputDto customerOutputDto = dtoMapper.convertCustomerToCustomerOutputDto(customerUpdated);
        return customerOutputDto;
    }

    @PostMapping(value = "/update/creditpoint")
    CustomerOutputDto updateCustomerCreditPoint(@RequestBody UpdateCustomerCreditPointInputDto updateCustomerCreditPointInputDto) {
        log.info("updateCustomerCreditPoint called with parameters: {}", updateCustomerCreditPointInputDto);
        Customer customerUpdated = customerService.updateCustomerCreditPoint(updateCustomerCreditPointInputDto.getTc(), updateCustomerCreditPointInputDto.getCreditPoint());
        CustomerOutputDto customerOutputDto = dtoMapper.convertCustomerToCustomerOutputDto(customerUpdated);
        return customerOutputDto;
    }

    @DeleteMapping(value = "/delete/{tc}")
    void deleteCustomer(@PathVariable long tc) {
        log.info("deleteCustomer called with TC:{}", tc);
        customerService.deleteByTc(tc);
    }

    @GetMapping(value = "/list")
    List<CustomerOutputDto> listCustomer() {
        log.info("listCustomer called:");
        List<CustomerOutputDto> customerOutputDtoList=new ArrayList<>();
        for (Customer customer: customerService.listCustomers()) {
            CustomerOutputDto customerOutputDto=dtoMapper.convertCustomerToCustomerOutputDto(customer);
            customerOutputDtoList.add(customerOutputDto);
        }
        return customerOutputDtoList;
    }
}
