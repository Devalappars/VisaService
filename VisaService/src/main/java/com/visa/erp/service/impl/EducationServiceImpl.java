package com.visa.erp.service.impl;

import com.visa.erp.DAO.AddressDao;
import com.visa.erp.DAO.EducationDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.model.*;
import com.visa.erp.repository.AddressRepository;
import com.visa.erp.repository.EducationRepository;
import com.visa.erp.service.AddressService;
import com.visa.erp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public EducationResponse findByStudentId(Long id) {
        EducationDao educationDao = educationRepository.findByStudentId(id);
        if(educationDao==null){
            EducationResponse educationResponse = new EducationResponse();
            educationResponse.setResult(commonUtility.noRecordsFound());
            return null;
        }
        return convertEducationDaoToResponse(educationDao);
    }

    @Override
    public EducationResponse save(EducationRequest educationRequest) {
        EducationDao educationDao = convertEducationRequestToDao(educationRequest);
        educationDao = educationRepository.save(educationDao);
        return convertEducationDaoToResponse(educationDao);
    }

    private EducationDao convertEducationRequestToDao(EducationRequest educationRequest) {
        EducationDao educationDao = new EducationDao();
        educationDao.setStudentId(educationRequest.getStudentId());
        educationDao.setEducation(educationRequest.getEducation());
        educationDao.setBoardOfEducation(educationRequest.getBoardOfEducation());
        educationDao.setScoreType(educationRequest.getScoreType());
        educationDao.setTotalScore(educationRequest.getTotalScore());
        educationDao.setMarksScored(educationRequest.getMarksScored());
        educationDao.setGrade(educationRequest.getGrade());
        educationDao.setYearOfCompletion(educationRequest.getYearOfCompletion());
        educationDao.setStatus(educationRequest.getStatus());
        educationDao.setCreatedDate(LocalDateTime.now());
        educationDao.setCreatedBy(VisaCommonConstants.SYSTEM);
        educationDao.setUpdatedDate(LocalDateTime.now());
        educationDao.setUpdatedBy(VisaCommonConstants.SYSTEM);
        return educationDao;
    }

    private EducationResponse convertEducationDaoToResponse(EducationDao educationDao) {
        EducationResponse educationResponse = new EducationResponse();
        EducationResponseDetail educationResponseDetail = new EducationResponseDetail();
        educationResponseDetail.setStudentId(educationDao.getStudentId());
        educationResponseDetail.setEducation(educationDao.getEducation());
        educationResponseDetail.setBoardOfEducation(educationDao.getBoardOfEducation());
        educationResponseDetail.setScoreType(educationDao.getScoreType());
        educationResponseDetail.setTotalScore(educationDao.getTotalScore());
        educationResponseDetail.setMarksScored(educationDao.getMarksScored());
        educationResponseDetail.setGrade(educationDao.getGrade());
        educationResponseDetail.setYearOfCompletion(educationDao.getYearOfCompletion());
        educationResponseDetail.setStatus(educationDao.getStatus());
        educationResponseDetail.setCreatedDate(LocalDateTime.now());
        educationResponseDetail.setCreatedBy(VisaCommonConstants.SYSTEM);
        educationResponseDetail.setUpdatedDate(LocalDateTime.now());
        educationResponseDetail.setUpdatedBy(VisaCommonConstants.SYSTEM);
        educationResponse.setData(educationResponseDetail);
        educationResponse.setResult(commonUtility.getSuccessResponse());
        return educationResponse;
    }
}