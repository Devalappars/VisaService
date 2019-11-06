package com.visa.erp.controller;

import com.visa.erp.model.EducationRequest;
import com.visa.erp.model.EducationResponse;
import com.visa.erp.model.SOFResponse;
import com.visa.erp.model.SourceOfFundRequest;
import com.visa.erp.service.EducationService;
import com.visa.erp.service.SourceOfFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class SourceOfFundController extends Throwable {

    private static final Logger log = Logger.getLogger(SourceOfFundController.class.getName());

    @Autowired
    private SourceOfFundService sourceOfFundService;

    @GetMapping(path = "/education/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SOFResponse getSofInfoById(@PathVariable("studentId") Long id) {
        return sourceOfFundService.findByStudentId(id);
    }

    @PostMapping(path = {"/education/{studentId}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SOFResponse saveSourceOfFundDetails(@Valid @RequestBody SourceOfFundRequest sourceOfFundRequest,
                                                     @PathVariable("studentId") Long id) {
        sourceOfFundRequest.setStudentId(id);
        return sourceOfFundService.save(sourceOfFundRequest);
    }
}