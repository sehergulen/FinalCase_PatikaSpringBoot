package com.credit.approval.app;

import com.credit.approval.app.model.Credit;
import com.credit.approval.app.model.Customer;
import com.credit.approval.app.repository.CreditRepository;
import com.credit.approval.app.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;
@Slf4j
@SpringBootTest
class CreditApprovalAppApplicationTests {
	@Autowired
	CreditRepository creditRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void test(){/*


		Optional<Customer> customerOptional=customerRepository.findByTc(1);

		if(customerOptional.isPresent()) {
			Credit credit=new Credit();
			credit.setCustomer(customerOptional.get());
			credit.setCreditLimit((Long.valueOf(100)));
			credit.setApproved(true);

			creditRepository.save(credit);
			log.info(credit.toString());

		}


		Customer customer=new Customer();
		customer.setName("kemal");
		customer.setSurname("baysarı");
		Date date=new Date(1995,3,9);
		customer.setBirthdate(date);
		customer.setTc(1);
		customer.setIncome(999999999999999999.9);
		customer.setPhoneNumber("sizene");
		customer.setCreditPoint(501);

		customerRepository.save(customer);

		Optional<Customer> customerOptional=customerRepository.findByTc(1);

		if(customerOptional.isPresent()){
			log.info(customerOptional.get().toString());
		}*/




	}
}
