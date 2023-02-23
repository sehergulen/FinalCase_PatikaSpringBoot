package com.credit.approval.app.repository;

import com.credit.approval.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByTc(long tc);
    @Transactional
    @Modifying
    void deleteByTc(long tc);
    @Query(value = "UPDATE Customer c SET c.creditPoint=?2 WHERE c.tc=?1")
    @Modifying
    @Transactional
    void updateCreditPoint(long tc, long creditPoint);

    @Query(value = "UPDATE Customer c SET c.income=?2 WHERE c.tc=?1")
    @Modifying
    @Transactional
    void updateIncome(long tc,double income);







}
