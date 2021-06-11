/**
 * 
 */
package com.java.techhub.email.demo.service;

import javax.mail.MessagingException;

import com.java.techhub.email.demo.model.User;

/**
 * @author mahes
 *
 */
public interface EmailService {

	String sendEmail(User user) throws MessagingException;
}
