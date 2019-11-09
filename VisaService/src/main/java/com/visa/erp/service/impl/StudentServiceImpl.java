package com.visa.erp.service.impl;

import com.visa.erp.DAO.ParentDetailsDao;
import com.visa.erp.DAO.StudentDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.CommonConstants;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.model.*;
import com.visa.erp.repository.ParentsRepository;
import com.visa.erp.repository.StudentsRepository;
import com.visa.erp.service.StudentService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private ParentsRepository parentsRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public StudentResponse findById(Long id) {
        StudentDao studentDao = studentsRepository.findById(id);
        if(studentDao==null){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setResult(commonUtility.noRecordsFound());
            return studentResponse;
        }
        return convertStudentDaoToResponse(studentDao);
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        StudentDao studentDao = convertStudentRequestToDao(studentRequest);
        studentDao = studentsRepository.save(studentDao);
        return convertStudentDaoToResponse(studentDao);
    }

    @Override
    public ContactDetailResponse findContactDetailById(Long id) {
        StudentDao studentDao = studentsRepository.findById(id);
        if(StringUtils.isEmpty(studentDao)){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setResult(commonUtility.noRecordsFound());

        }
        ParentDetailsDao detailsDao = parentsRepository.findByStudentId(id);
        return convertContactDao(studentDao,detailsDao);
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
        studentDao.setCreatedBy(VisaCommonConstants.SYSTEM);
        studentDao.setUpdatedDate(LocalDateTime.now());
        studentDao.setUpdatedBy(VisaCommonConstants.SYSTEM);
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
        student.setStudentId(studentDao.getId());
        student.setCreatedDate(LocalDateTime.now());
        student.setCreatedBy(VisaCommonConstants.SYSTEM);
        student.setUpdatedDate(LocalDateTime.now());
        student.setUpdatedBy(VisaCommonConstants.SYSTEM);
        studentResponse.setData(student);
        studentResponse.setResult(commonUtility.getSuccessResponse());
        return studentResponse;
    }

    private ContactDetailResponse convertContactDao(StudentDao studentDao, ParentDetailsDao parentDetailsDao ){
        StudentContactDetail contactDetail = new StudentContactDetail();
        ContactDetailResponse response = new ContactDetailResponse();
        contactDetail.setStudentId(studentDao.getId());
        contactDetail.setMobile(studentDao.getMobile());
        contactDetail.setAlternateMobile(studentDao.getAlternateMobile());
        contactDetail.setEmail(studentDao.getEmail());
        contactDetail.setParentMobile(parentDetailsDao.getMobile());
        contactDetail.setParentAlternateMobile(parentDetailsDao.getAlternateMobile());
        response.setData(contactDetail);
        response.setResult(commonUtility.getSuccessResponse());
        return response;
    }
}