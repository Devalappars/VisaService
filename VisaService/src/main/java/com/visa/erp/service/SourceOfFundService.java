package com.visa.erp.service;

import com.visa.erp.model.EducationRequest;
import com.visa.erp.model.EducationResponse;
import com.visa.erp.model.SOFResponse;
import com.visa.erp.model.SourceOfFundRequest;

public interface SourceOfFundService {
    SOFResponse findByStudentId(Long id);

    SOFResponse save(SourceOfFundRequest sourceOfFundRequest);
}