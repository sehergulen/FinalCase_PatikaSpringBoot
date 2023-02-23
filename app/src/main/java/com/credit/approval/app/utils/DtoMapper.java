package com.credit.approval.app.utils;

import com.credit.approval.app.dto.output.CreditOutputDto;
import com.credit.approval.app.dto.output.CustomerOutputDto;
import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class DtoMapper {
    public CustomerOutputDto convertCustomerToCustomerOutputDto(Customer customer) {
        CustomerOutputDto customerOutputDto = new CustomerOutputDto();
        customerOutputDto.setId(customer.getId());
        customerOutputDto.setName(customer.getName());
        customerOutputDto.setSurname(customer.getSurname());
        customerOutputDto.setBirthdate(customer.getBirthdate());
        customerOutputDto.setTc(customer.getTc());
        customerOutputDto.setPhoneNumber(customer.getPhoneNumber());
        customerOutputDto.setIncome(customer.getIncome());
        customerOutputDto.setCreditPoint(customer.getCreditPoint());
        return customerOutputDto;
    }
    public CreditOutputDto convertCreditToCreditOutputDto(Credit credit) {
        CreditOutputDto creditOutputDto = new CreditOutputDto();
        creditOutputDto.setName(credit.getCustomer().getName());
        creditOutputDto.setSurname(credit.getCustomer().getSurname());
        creditOutputDto.setCreditLimit(credit.getCreditLimit());
        creditOutputDto.setApproved(credit.isApproved());
        return creditOutputDto;
    }

}
