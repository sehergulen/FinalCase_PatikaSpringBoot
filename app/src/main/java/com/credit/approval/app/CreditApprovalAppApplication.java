package com.credit.approval.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CreditApprovalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditApprovalAppApplication.class, args);
	}

}
