package com.visa.erp.controller;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;
import com.visa.erp.service.AddressService;
import com.visa.erp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class AddressController extends Throwable {

    private static final Logger log = Logger.getLogger(AddressController.class.getName());

    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/address/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressResponse getAddressByStudentId(@PathVariable("studentId") Long id) {
        return addressService.findByStudentId(id);
    }

    @PostMapping(path = {"/address/{studentId}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressResponse saveAddress(@Valid @RequestBody AddressRequest addressRequest, @PathVariable("studentId") Long id) {
        addressRequest.setStudentId(id);
        return addressService.save(addressRequest);
    }
}