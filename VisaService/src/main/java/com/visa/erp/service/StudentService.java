package com.visa.erp.service;

import com.visa.erp.model.ContactDetailResponse;
import com.visa.erp.model.StudentContactDetail;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;

public interface StudentService {
    StudentResponse findById(Long id);
    StudentResponse save(StudentRequest s);
    ContactDetailResponse findContactDetailById(Long id);
}