package com.visa.erp.service.impl;

import com.visa.erp.DAO.SOFDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.model.SOFResponse;
import com.visa.erp.model.SOFResponseDetails;
import com.visa.erp.model.SourceOfFundRequest;
import com.visa.erp.repository.SOFRepository;
import com.visa.erp.service.SourceOfFundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class SourceOfFundServiceImpl implements SourceOfFundService {

    @Autowired
    private SOFRepository sofRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public SOFResponse findByStudentId(Long id) {
        SOFDao sofDao = sofRepository.findByStudentId(id);
        return convertDAOInResponse(sofDao);
    }

    @Override
    public SOFResponse save(SourceOfFundRequest sourceOfFundRequest) {
        SOFDao sofDao = convertSOFRequestIntoDAO(sourceOfFundRequest);
        try{
            sofDao = sofRepository.save(sofDao);
        }catch (Exception e){

        }
        return convertDAOInResponse(sofDao);
    }

    private SOFDao convertSOFRequestIntoDAO(SourceOfFundRequest sourceOfFundRequest){
        SOFDao request = new SOFDao();
        request.setJobCategory(sourceOfFundRequest.getJobCategory());
        request.setJobType(sourceOfFundRequest.getJobType());
        request.setMonthlyIncome(sourceOfFundRequest.getMonthlyIncome());
        request.setParentsOccupation(sourceOfFundRequest.getParentsOccupation());
        request.setProofOfIncomeDocumentType(sourceOfFundRequest.getProofOfIncomeDocumentType());
        request.setStudentId(sourceOfFundRequest.getStudentId());
        request.setCreatedDate(LocalDateTime.now());
        request.setCreatedBy(VisaCommonConstants.SYSTEM);
        request.setUpdatedDate(LocalDateTime.now());
        request.setUpdatedBy(VisaCommonConstants.SYSTEM);
        return request;
    }

    private SOFResponse convertDAOInResponse(SOFDao sofDao){
        SOFResponse response = new SOFResponse();
        SOFResponseDetails responseDetails = new SOFResponseDetails();
        responseDetails.setStudentId(sofDao.getStudentId());
        responseDetails.setCreatedBy(sofDao.getCreatedBy());
        responseDetails.setCreatedDate(sofDao.getCreatedDate());
        responseDetails.setJobCategory(sofDao.getJobCategory());
        responseDetails.setJobType(sofDao.getJobType());
        responseDetails.setMonthlyIncome(sofDao.getMonthlyIncome());
        responseDetails.setParentsOccupation(sofDao.getParentsOccupation());
        responseDetails.setProofOfIncomeDocumentType(sofDao.getProofOfIncomeDocumentType());
        responseDetails.setUpdatedBy(sofDao.getUpdatedBy());
        responseDetails.setUpdatedDate(sofDao.getUpdatedDate());
        response.setData(responseDetails);
        response.setResult(commonUtility.getSuccessResponse());
        return response;
    }
}
