package com.credit.approval.app.impl;

import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.repository.CreditRepository;
import com.credit.approval.app.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;
@Slf4j
@ExtendWith(MockitoExtension.class)
public class Test {/*
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository; // as copy

    @Mock
    private CreditRepository creditRepository;

    @org.junit.jupiter.api.Test
    public void testaddCustomer(){
        Optional<Customer> customerOptional=customerRepository.findByTc(1);

        if(customerOptional.isPresent()) {
            Credit credit=new Credit();
            credit.setCustomer(customerOptional.get());
            credit.setCreditLimit((Long.valueOf(100)));
            credit.setApproved(true);

            creditRepository.save(credit);
            log.info(credit.toString());

        }

        Customer customer=new Customer();
        customer.setName("kemal");
        customer.setSurname("baysarı");
        Date date=new Date(1995,3,9);
        customer.setBirthdate(String.valueOf(date));
        customer.setTc(33333);
        customer.setIncome(9999.9);
        customer.setPhoneNumber("sizene");
        customer.setCreditPoint(501);
        customerRepository.save(customer);

        if(customerOptional.isPresent()){
            log.info(customerOptional.get().toString());
        }


        Customer mockCostumer=mock(Customer.class);

        when(mockCostumer.getTc()).thenReturn(33333L);
        when(mockCostumer.getName()).thenReturn("seher");

        when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(mockCostumer);

        //  Assertions.assertEquals(mockCustomer.getTc(),customer.getTc());
        Assertions.assertEquals(mockCostumer.getName(),customer.getName());
    }*/
}
