package com.visa.erp.service.impl;

import com.visa.erp.DAO.StudentDao;
import com.visa.erp.model.Result;
import com.visa.erp.model.StudentRequest;
import com.visa.erp.model.StudentResponse;
import com.visa.erp.model.StudentResponseDetail;
import com.visa.erp.repository.StudentsRepository;
import com.visa.erp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public StudentResponse findById(Long id) {
        StudentDao studentDao = studentsRepository.findById(id);
        return convertStudentDaoToResponse(studentDao);
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        StudentDao studentDao = convertStudentRequestToDao(studentRequest);
        studentDao = studentsRepository.save(studentDao);
        return convertStudentDaoToResponse(studentDao);
    }

    private StudentDao convertStudentRequestToDao(StudentRequest studentRequest) {
        StudentDao studentDao = new StudentDao();
        studentDao.setFirstName(studentRequest.getFirstName());
        studentDao.setMiddleName(studentRequest.getMiddleName());
        studentDao.setLastName(studentRequest.getLastName());
        studentDao.setGender(studentRequest.getGender());
        studentDao.setDob(studentRequest.getDob());
        studentDao.setMobile(studentRequest.getMobile());
        studentDao.setAlternateMobile(studentRequest.getAlternateMobile());
        studentDao.setEmail(studentRequest.getEmail());
        studentDao.setEnrollmentStatus(studentRequest.getEnrollmentStatus());
        studentDao.setEnrollmentYear(studentRequest.getEnrollmentYear());
        studentDao.setCreatedDate(LocalDateTime.now());
        studentDao.setCreatedBy("System");
        studentDao.setUpdatedDate(LocalDateTime.now());
        studentDao.setUpdatedBy("System");
        return studentDao;
    }

    private StudentResponse convertStudentDaoToResponse(StudentDao studentDao) {
        StudentResponse studentResponse = new StudentResponse();
        StudentResponseDetail student = new StudentResponseDetail();
        student.setFirstName(studentDao.getFirstName());
        student.setMiddleName(studentDao.getMiddleName());
        student.setLastName(studentDao.getLastName());
        student.setGender(studentDao.getGender());
        student.setDob(studentDao.getDob());
        student.setMobile(studentDao.getMobile());
        student.setAlternateMobile(studentDao.getAlternateMobile());
        student.setEmail(studentDao.getEmail());
        student.setEnrollmentStatus(studentDao.getEnrollmentStatus());
        student.setEnrollmentYear(studentDao.getEnrollmentYear());
        student.setCreatedDate(LocalDateTime.now());
        student.setCreatedBy("System");
        student.setUpdatedDate(LocalDateTime.now());
        student.setUpdatedBy("System");
        studentResponse.setData(student);
        studentResponse.setResult(getSuccessResponse());
        return studentResponse;
    }

    private Result getSuccessResponse(){
        Result result = new Result("0","Success");
        return result;
    }
}