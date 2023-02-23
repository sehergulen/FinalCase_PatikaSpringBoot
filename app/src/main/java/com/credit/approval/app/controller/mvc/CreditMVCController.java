package com.credit.approval.app.controller.mvc;

import com.credit.approval.app.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(value="/creditMvc")
public class CreditMVCController {

    @Autowired
    CreditService creditService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String showCustomers(ModelMap model){
        model.put("credits", creditService.findAllCredits());
        return "list_credits";
    }
}
