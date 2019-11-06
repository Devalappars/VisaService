package com.visa.erp.service;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.PassportRequest;
import com.visa.erp.model.PassportResponse;

public interface PassportService {
    PassportResponse findByStudentId(Long id);
    PassportResponse save(PassportRequest passportRequest);
}