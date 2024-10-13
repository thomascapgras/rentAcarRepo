package com.project.rentAcar.controlleurs;

import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.AgencyService;
import com.project.rentAcar.validators.ValidId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * This controller handles agency-related endpoints.
 */
@RestController
@RequestMapping("/agency")
@Validated
public class AgencyController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AgencyController.class);
    @Autowired
    private AgencyService agencyService;

    public AgencyController(){
        logger.info("Enter into : " + AgencyController.class);
    }

    /**
     * Finds an agency by ID.
     *
     * @param id the ID of the agency to search
     * @return a response entity containing the agency and HTTP status OK,
     * or a message with HTTP status NOT FOUND if no agency is found
     */
    @GetMapping("/getAgencyById/{id}")
    public ResponseEntity<?> getAgencyById(@PathVariable @ValidId(entityClass = Agency.class) int id) throws RessourceNotFoundException {
        Agency agency = this.agencyService.findAgencyById(id);
        logger.info("Enter into findAgencyById endpoint method" );
        if (agency == null) {
            logger.info("Agency not found with id : " + id);
            return new ResponseEntity<>("Agency not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        logger.info("Sending back agency");
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }
}
