package com.visa.erp.controller;

import java.util.logging.Logger;

import com.visa.erp.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class VisaController extends Throwable {

	private static final Logger log = Logger.getLogger(VisaController.class.getName());

	@Autowired
	private VisaService visaService;
	
}
