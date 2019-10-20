package com.visa.erp.service.impl;

import com.visa.erp.DAO.StudentDao;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;
import com.visa.erp.repository.StudentsRepository;
import com.visa.erp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public StudentResponse findById(Long id) {
        StudentDao studentDao = studentsRepository.findById(id);
        return null;
    }

    @Override
    public StudentResponse save(StudentRequest s) {
        StudentDao studentDao = null;
        studentDao = studentsRepository.save(studentDao);
        return null;
    }
}