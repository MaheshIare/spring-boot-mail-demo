/**
 * 
 */
package com.java.techhub.email.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.techhub.email.demo.model.User;
import com.java.techhub.email.demo.service.EmailService;

/**
 * @author mahes
 *
 */
@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> sendEmail(@RequestBody User user) throws MessagingException{
		Map<String, Object> map = new HashMap<>();
		map.put("message", emailService.sendEmail(user));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
