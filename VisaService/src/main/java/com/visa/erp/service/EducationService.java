package com.visa.erp.service;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.EducationRequest;
import com.visa.erp.model.EducationResponse;

public interface EducationService {
    EducationResponse findByStudentId(Long id);

    EducationResponse save(EducationRequest educationRequest);
}