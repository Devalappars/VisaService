package com.visa.erp.service;

import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;

public interface AddressService {
    AddressResponse findByStudentId(Long id);
    AddressResponse save(AddressRequest addressRequest);
}