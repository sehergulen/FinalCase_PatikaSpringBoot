package com.credit.approval.app.impl;

import com.credit.approval.app.exception.ExceptionCreator;
import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.repository.CreditRepository;
import com.credit.approval.app.service.CreditService;
import com.credit.approval.app.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CreditServiceImpl implements CreditService {
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    ExceptionCreator exceptionCreator;

    @Value("${credit.limit.factor}")
    private double creditLimitFactor;


    @Override
    public Credit addCredit(long tc, double deposit) {
        Optional<Customer> customerOptional = customerService.findCustomerByTc(tc);
        if (!customerOptional.isPresent()) {
            log.error("Customer:{} is does not exist.Credit cant be added.", customerOptional.get());
            throw exceptionCreator.createCustomerDoesNotExistException(tc);
        } else {
            Customer customer = customerOptional.get();
            Credit credit = new Credit();
            credit.setCustomer(customer);
            calculateCreditRequirement(credit, deposit, customer);
            creditRepository.save(credit);
            log.info("credit saved to database:{} to customerTC:{}", credit, tc);
            sentSMS(customer,credit);
            return credit;
        }
    }

    private void calculateCreditRequirement(Credit credit, double deposit, Customer customer) {
        if (customer.getCreditPoint() < 500) {
            credit.setApproved(false);
            credit.setCreditLimit(0);
        } else if (customer.getCreditPoint() >= 500 && customer.getCreditPoint() <= 1000) {
            if (customer.getIncome() < 5000) {
                credit.setCreditLimit(10000);
                credit.setApproved(true);
                double creditLimit = credit.getCreditLimit();
                creditLimit += (deposit * 10) / 100;
                credit.setCreditLimit(creditLimit);
            } else if (customer.getIncome() >= 5000 && customer.getIncome() <= 10000) {
                credit.setCreditLimit(20000);
                credit.setApproved(true);
                double creditLimit = credit.getCreditLimit();
                creditLimit += (deposit * 20) / 100;
                credit.setCreditLimit(creditLimit);
            } else if (customer.getIncome() > 10000) {
                credit.setCreditLimit((creditLimitFactor * customer.getIncome()) / 2);
                credit.setApproved(true);
                double creditLimit = credit.getCreditLimit();
                creditLimit += (deposit * 25) / 100;
                credit.setCreditLimit(creditLimit);
            }
        } else {
            credit.setCreditLimit(creditLimitFactor * customer.getIncome());
            credit.setApproved(true);
            double creditLimit = credit.getCreditLimit();
            creditLimit += (deposit * 50) / 100;
            credit.setCreditLimit(creditLimit);
        }
    }
    private void sentSMS(Customer customer,Credit credit){
        log.info("credit result:{} sending SMS.... {}", credit.isApproved(),credit);
    }

    @Override
    public List<Credit> listCreditByTcAndBirthdate(long tc, String birthdate) {
        return creditRepository.findByCustomer_TcAndCustomer_Birthdate(tc,birthdate);
    }

    @Override
    public List<Credit> findAllCredits() {
        return creditRepository.findAll();
    }
}