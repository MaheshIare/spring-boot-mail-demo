package com.java.techhub.email.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.techhub.email.demo.controller.EmailController;
import com.java.techhub.email.demo.model.User;
import com.java.techhub.email.demo.service.EmailService;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest {
	
	@InjectMocks
	private EmailController emailController;
	
	@Mock
	private EmailService emailService;

	@Test
	void testSendEmail() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(emailService.sendEmail(ArgumentMatchers.any(User.class))).thenReturn("Success");
        ResponseEntity<Map<String, Object>> responseEntity = emailController.sendEmail(UserUtil.getUser(true));
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().get("message")).isNotNull();
	}

}
