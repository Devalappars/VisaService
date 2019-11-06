package com.visa.erp.service.impl;

import com.visa.erp.DAO.PassportDao;
import com.visa.erp.DAO.SOFDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.model.*;
import com.visa.erp.repository.PassportRepository;
import com.visa.erp.repository.SOFRepository;
import com.visa.erp.service.PassportService;
import com.visa.erp.service.SourceOfFundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public PassportResponse findByStudentId(Long id) {
        PassportDao passportDao = passportRepository.findByStudentId(id);
        return convertDAOInResponse(passportDao);
    }

    @Override
    public PassportResponse save(PassportRequest passportRequest) {
        PassportDao passportDao = convertSOFRequestIntoDAO(passportRequest);
        try{
            passportDao = passportRepository.save(passportDao);
        }catch (Exception e){

        }
        return convertDAOInResponse(passportDao);
    }

    private PassportDao convertSOFRequestIntoDAO(PassportRequest passportRequest){
        PassportDao request = new PassportDao();
        request.setExpiryDate(passportRequest.getExpiryDate());
        request.setIssuedDate(passportRequest.getIssuedDate());
        request.setPassportId(passportRequest.getPassportId());
        request.setPlaceOfIssued(passportRequest.getPlaceOfIssued());
        request.setStudentId(passportRequest.getStudentId());
        request.setCreatedDate(LocalDateTime.now());
        request.setCreatedBy(VisaCommonConstants.SYSTEM);
        request.setUpdatedDate(LocalDateTime.now());
        request.setUpdatedBy(VisaCommonConstants.SYSTEM);
        return request;
    }

    private PassportResponse convertDAOInResponse(PassportDao passportDao){
        PassportResponse response = new PassportResponse();
        PassportDetailsResponse responseDetails = new PassportDetailsResponse();
        responseDetails.setExpiryDate(passportDao.getExpiryDate());
        responseDetails.setIssuedDate(passportDao.getIssuedDate());
        responseDetails.setPassportId(passportDao.getPassportId());
        responseDetails.setPlaceOfIssued(passportDao.getPlaceOfIssued());
        responseDetails.setStudentId(passportDao.getStudentId());
        responseDetails.setCreatedBy(passportDao.getCreatedBy());
        responseDetails.setCreatedDate(passportDao.getCreatedDate());
        responseDetails.setUpdatedBy(passportDao.getUpdatedBy());
        responseDetails.setUpdatedDate(passportDao.getUpdatedDate());
        response.setData(responseDetails);
        response.setResult(commonUtility.getSuccessResponse());
        return response;
    }
}
