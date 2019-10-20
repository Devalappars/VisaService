package com.visa.erp.service;

import com.visa.erp.model.ParentRequest;
import com.visa.erp.model.ParentResponse;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;

public interface ParentService {
    ParentResponse save(ParentRequest s);
    ParentResponse findById(Long id);
}