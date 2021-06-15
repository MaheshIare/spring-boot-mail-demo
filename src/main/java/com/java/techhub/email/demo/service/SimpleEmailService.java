/**
 * 
 */
package com.java.techhub.email.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.java.techhub.email.demo.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mahes
 *
 */
@Slf4j
@Service
public class SimpleEmailService implements EmailService {

	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${user.personal.repo.link}")
	private String userLink;

	@Value("${user.personal.repo.type}")
	private String userBlogType;

	@Override
	public String sendEmail(User user) throws MessagingException {
		log.info("Sending emails...");
		final AtomicInteger counter = new AtomicInteger(0);
		user.getEmails().forEach(usr -> {
			try {
				Context context = new Context();
				Map<String, Object> map = new HashMap<>();
				map.put("firstname", usr.getFirstName());
				map.put("lastname", usr.getLastName());
				map.put("name", StringUtils.join(Arrays.asList(usr.getFirstName(), usr.getLastName()), ' '));
				map.put("sign", StringUtils.join(Arrays.asList(user.getFirstName(), user.getLastName()), ' '));
				map.put("location", user.getLocation());
				map.put("uniqueid", UUID.randomUUID().toString());
				map.put("repo", userLink);
				map.put("blogtype", userBlogType);
				context.setVariables(map);
				String process = springTemplateEngine.process("welcome", context);
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				String subject = StringUtils
						.join(Arrays.asList("Greetings", usr.getFirstName(), usr.getLastName(), "!!!"), ' ');
				helper.setSubject(subject);
				helper.setText(process, true);
				helper.setTo(usr.getEmail());
				helper.setFrom(username);
				javaMailSender.send(mimeMessage);
			} catch (MessagingException | MailException ex) {
				log.error("Exception occured while sending email to: {} {}, due to: {}", usr.getFirstName(),
						usr.getLastName(), ex.getMessage());
				counter.incrementAndGet();
			}
		});
		if (counter.intValue() > 0) {
			return counter.intValue() + " email(s) sending failed. Please verify logs...!!!";
		}
		return "Email(s) sent successfully, Please check your inbox...!!!";
	}
}
