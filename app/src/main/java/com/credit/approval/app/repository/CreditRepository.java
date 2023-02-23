package com.credit.approval.app.repository;

import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    List<Credit> findByCustomer_TcAndCustomer_Birthdate(long tc,String birthdate);

    List<Credit> findByCustomer_TcAndApproved(long tc,boolean approved);

    List<Credit> findAllByApproved(boolean approved);










}
