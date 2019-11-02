package com.visa.erp.controller;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.EducationRequest;
import com.visa.erp.model.EducationResponse;
import com.visa.erp.service.AddressService;
import com.visa.erp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class EducationController extends Throwable {

    private static final Logger log = Logger.getLogger(EducationController.class.getName());

    @Autowired
    private EducationService educationService;

    @GetMapping(path = "/education/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EducationResponse getEducationByEducationId(@PathVariable("studentId") Long id) {
        return educationService.findByStudentId(id);
    }

    @PostMapping(path = {"/education/{studentId}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EducationResponse saveEducation(@Valid @RequestBody EducationRequest educationRequest, @PathVariable("studentId") Long id) {
        educationRequest.setStudentId(id);
        return educationService.save(educationRequest);
    }
}