package com.project.rentAcar.controlleurs;

import com.project.rentAcar.dto.ContactDto;
import com.project.rentAcar.services.ContactService;
import com.project.rentAcar.services.EmailService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles contact-related endpoints.
 */
@RestController
@RequestMapping("/contact")
@Validated
public class ContactController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Value("${contact.email.issuer}")
    private String issuer;

    public ContactController(){
        logger.info("Enter into : " + ContactController.class);
    }
    @Autowired
    private EmailService emailService;

    @Autowired
    private ContactService contactService;

    /**
     * Saves a new contact message and sends an email notification.
     *
     * @param contactDto contains email and message from the user
     * @return a response entity with a confirmation message and HTTP status CREATED
     */
    @PostMapping("/saveContact")
    public ResponseEntity<?> saveContact(@RequestBody @Valid ContactDto contactDto) {
        logger.info("Enter into saveContact endpoint method" );
        emailService.sendSimpleMessage(issuer, "Request from: " + contactDto.getEmail(), contactDto.getMessage());
        this.contactService.saveContact(contactDto);
        logger.info("Sending back contact");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\":\"saved contact message\"}");
    }
}
