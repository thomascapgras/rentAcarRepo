package com.project.rentAcar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Service for sending emails.
 */
@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService(){
        logger.info("Enter into ; " + EmailService.class);
    }

    /**
     * Sends a simple email message.
     *
     * @param to      the recipient email address
     * @param subject the subject of the email
     * @param text    the body text of the email
     */
    public void sendSimpleMessage(String to, String subject, String text) {
        logger.info("Enter into sendSimpleMessage method");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);
        logger.info("Sending email to : " + to);
        javaMailSender.send(msg);
    }
}
