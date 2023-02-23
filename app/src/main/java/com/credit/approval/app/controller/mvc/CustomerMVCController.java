package com.credit.approval.app.controller.mvc;

import com.credit.approval.app.model.Customer;
import com.credit.approval.app.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value="/customerMvc")
public class CustomerMVCController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String showCustomers(ModelMap model){
        model.put("customers", customerService.listCustomers());
        return "list_customers";
    }
}
