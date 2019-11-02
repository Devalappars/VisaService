package com.visa.erp.controller;

import com.visa.erp.model.IdDetailsRequest;
import com.visa.erp.model.IdDetailsResponse;
import com.visa.erp.service.IdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class IDDetailsController extends Throwable {

    private static final Logger log = Logger.getLogger(IDDetailsController.class.getName());

    @Autowired
    private IdDetailsService idDetailsService;

    @GetMapping(path = "/idDetails/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public IdDetailsResponse getIdDetailsByStudentId(@PathVariable("studentId") Long id) {
        return idDetailsService.findByStudentId(id);
    }

    @PostMapping(path = {"/idDetails/{studentId}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdDetailsResponse saveIdDetails(@Valid @RequestBody IdDetailsRequest idDetailsRequest, @PathVariable("studentId") Long id) {
        idDetailsRequest.setStudentId(id);
        return idDetailsService.save(idDetailsRequest);
    }
}