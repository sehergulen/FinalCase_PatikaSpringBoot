package com.credit.approval.app.service;

import com.credit.approval.app.model.Credit;

import java.util.List;

public interface CreditService {
    Credit addCredit(long tc,double deposit);

    List<Credit> findAllCredits();

    List<Credit> listCreditByTcAndBirthdate(long tc,String birthdate);



}
