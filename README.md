# spring-boot-swagger-demo

This is a simple spring application developed using Spring boot to demonstrate the integration of **[Spring Mail](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mail.html)** module for sending emails using html templates. This application is integrated with Gmail SMTP server that sends email(s), so in order to send emails using your Gmail account we need to change the Gmail account settings to provide permissions for other apps to be integrated. More details on how to change gmail account settings, click here: **[Enable Less secure apps](https://support.google.com/accounts/answer/6010255?hl=en)**

## Build


```bash
mvn clean install
```

Build status: [![Maven Package](https://github.com/MaheshIare/spring-boot-mail-demo/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/MaheshIare/spring-boot-mail-demo/actions/workflows/maven-publish.yml)

Sonar status: [![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=MaheshIare_spring-boot-mail-demo)


## Description
Application consists of a POST API(/email) which accepts sender and receiver information in the request body which includes receiver email-id(s) for sending email(s). 
Dependencies to be added:

```bash

	<!-- Spring mail boot starter -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-mail</artifactId>
	</dependency>
	
	<!-- Thymeleaf dependency for html templates -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
		
```

Additional auto configuration to be added to application.properties file

```java

### Email configuration ###
spring.mail.username=<gmail-id>
spring.mail.password=<password>
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.protocol=smtp
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
spring.mail.properties.mail.smtp.starttls.enable=true

```

## Contributing
Thanks much. Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.
