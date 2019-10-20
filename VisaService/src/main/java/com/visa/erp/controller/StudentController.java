package com.visa.erp.controller;

import com.visa.erp.model.*;
import com.visa.erp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class StudentController extends Throwable {

    private static final Logger log = Logger.getLogger(StudentController.class.getName());

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse getStudentById(@QueryParam("id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping(path = {"/student"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse saveStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }
}