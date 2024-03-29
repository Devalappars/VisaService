package com.visa.erp.controller;

import com.visa.erp.model.ParentRequest;
import com.visa.erp.model.ParentResponse;
import com.visa.erp.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class ParentController extends Throwable {

    @Autowired
    private ParentService parentService;

    @GetMapping(path = "/parent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParentResponse getParentById(@PathVariable("id") Long id) {
        return parentService.findById(id);
    }

    @PostMapping(path = {"/parent/{studentId}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ParentResponse saveParent(@Valid @RequestBody ParentRequest parentRequest, @PathVariable("studentId") Long id) {
        parentRequest.setStudentId(id);
        return parentService.save(parentRequest);
    }
}