package com.credit.approval.app.impl;

import com.credit.approval.app.exception.ExceptionCreator;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.repository.CustomerRepository;
import com.credit.approval.app.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ExceptionCreator exceptionCreator;

    @Override
    public Customer addCustomer(String name, String surname, long tc, String birthdate, String phoneNumber, double income) {
        Optional<Customer> customerOptional = findCustomerByTc(tc);
        if (customerOptional.isPresent()) {
            log.error("customer:{} is already exist.", customerOptional.get());
            throw exceptionCreator.createCustomerAlreadyDefinedException(tc);
        } else {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setSurname(surname);
            customer.setBirthdate(birthdate);
            customer.setTc(tc);
            customer.setIncome(income);
            customer.setPhoneNumber(phoneNumber);
            customer.setCreditPoint(creditPointCreator());
            customer = customerRepository.save(customer);
            log.info("customer saved to database:{}", customer);
            return customer;
        }
    }

    private int creditPointCreator() {
        // create random credit point
        Random random = new Random();
        return random.nextInt(15) * 100; // Between 0 - 1500

    }

    @Override
    public Optional<Customer> findCustomerByTc(long tc) {
        return customerRepository.findByTc(tc);
    }

    @Override
    public void deleteByTc(long tc) {
        Optional<Customer> customerOptional = findCustomerByTc(tc);
        if (!customerOptional.isPresent()) {
            log.error("customer:{} is does not exist.", customerOptional.get());
            throw exceptionCreator.createCustomerDoesNotExistException(tc);
        } else {
            customerRepository.deleteByTc(tc);
            log.info("customer deleted from the database:{}", customerOptional.get());
        }
    }

    @Override
    public Customer updateCustomerIncome(long tc, double income) {
        Optional<Customer> customerOptional = findCustomerByTc(tc);
        if (!customerOptional.isPresent()) {
            log.error("customer:{} is does not exist.", tc);
            throw exceptionCreator.createCustomerDoesNotExistException(tc);
        } else {
            Customer customer =  customerOptional.get();
            customer.setIncome(income);
            customerRepository.updateIncome(customer.getTc(), customer.getIncome());
            log.info("customer updated from the database:{}", customer);
            return customer;
        }

    }

    @Override
    public Customer updateCustomerCreditPoint(long tc, long creditPoint) {
        Optional<Customer> customerOptional = findCustomerByTc(tc);
        if (!customerOptional.isPresent()) {
            log.error("customer:{} is does not exist.", tc);
            throw exceptionCreator.createCustomerDoesNotExistException(tc);
        } else {
            Customer customer =  customerOptional.get();
            customer.setCreditPoint(creditPoint);
            customerRepository.updateCreditPoint(customer.getTc(), customer.getCreditPoint());
            log.info("customer credit point updated from the database:{}", customer);
            return customer;
        }
    }

    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }
}
