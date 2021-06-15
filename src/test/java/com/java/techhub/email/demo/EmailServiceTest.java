package com.java.techhub.email.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.techhub.email.demo.service.EmailService;

/**
 * @author mahes
 *
 */
@SpringBootTest
public class EmailServiceTest {

	@Autowired
	private EmailService emailService;
	
	@Test
	public void testSendEmail() throws Exception {
		String response = emailService.sendEmail(UserUtil.getUser());
		Assertions.assertEquals("1 email(s) sending failed. Please verify logs...!!!",	 response);
	}
}
