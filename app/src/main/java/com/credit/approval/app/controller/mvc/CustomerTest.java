package com.credit.approval.app.controller.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(value="/customerMvc")
public class CustomerTest {
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test(){
        return "customer";
    }
}
