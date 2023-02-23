package com.credit.approval.app.service;

import com.credit.approval.app.model.Customer;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addCustomer(String name, String surname, long tc, String birthdate,String phoneNumber,double income);

    Optional<Customer> findCustomerByTc(long tc);
    List<Customer> listCustomers();
    void deleteByTc(long tc);
    Customer updateCustomerIncome(long tc,double income);
    Customer updateCustomerCreditPoint(long tc,long creditPoint);


}
