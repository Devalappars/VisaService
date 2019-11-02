package com.visa.erp.service;

import com.visa.erp.model.IdDetailsRequest;
import com.visa.erp.model.IdDetailsResponse;

public interface IdDetailsService {
    IdDetailsResponse findByStudentId(Long id);

    IdDetailsResponse save(IdDetailsRequest idDetailsRequest);
}