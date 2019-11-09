package com.visa.erp.controller;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.PassportRequest;
import com.visa.erp.model.PassportResponse;
import com.visa.erp.service.AddressService;
import com.visa.erp.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class PassportController extends Throwable {

    private static final Logger log = Logger.getLogger(PassportController.class.getName());

    @Autowired
    private PassportService passportService;

    @GetMapping(path = "/student/passport/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PassportResponse getDetailsByStudentId(@PathVariable("studentId") Long id) {
        return passportService.findByStudentId(id);
    }

    @PostMapping(path = {"/student/passport"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PassportResponse savePassportDetails(@Valid @RequestBody PassportRequest passportRequest) {
        return passportService.save(passportRequest);
    }
}