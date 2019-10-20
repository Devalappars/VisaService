package com.visa.erp.service;

import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;

public interface StudentService {
    StudentResponse findById(Long id);
    StudentResponse save(StudentRequest s);
}