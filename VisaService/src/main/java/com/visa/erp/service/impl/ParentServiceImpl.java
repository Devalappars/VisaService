package com.visa.erp.service.impl;

import com.visa.erp.DAO.ParentDetailsDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.controller.ParentController;
import com.visa.erp.model.ParentRequest;
import com.visa.erp.model.ParentResponse;
import com.visa.erp.model.ParentResponseDetail;
import com.visa.erp.repository.ParentsRepository;
import com.visa.erp.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    ParentsRepository parentsRepository;

    @Autowired
    CommonUtility utility;

    private static final Logger log = Logger.getLogger(ParentServiceImpl.class.getName());

    @Override
    public ParentResponse save(ParentRequest request) {
        ParentDetailsDao parentDetails = convertParentDetailsDao(request) ;
        ParentDetailsDao parentDetailsDao = parentsRepository.save(parentDetails);
        return convertParentDetailsDAOToResponse(parentDetailsDao);
    }

    @Override
    public ParentResponse findById(Long id) {
        ParentDetailsDao detailsDao = parentsRepository.findById(id);
        return convertParentDetailsDAOToResponse(detailsDao);
    }

    private ParentDetailsDao convertParentDetailsDao(ParentRequest parentRequest){
        ParentDetailsDao detailsDao = new ParentDetailsDao();
        detailsDao.setAlternateMobile(parentRequest.getAlternateMobile());
        detailsDao.setEmail(parentRequest.getEmail());
        detailsDao.setFirstName(parentRequest.getFirstName());
        detailsDao.setLastName(parentRequest.getLastName());
        detailsDao.setMiddleName(parentRequest.getMiddleName());
        detailsDao.setMobile(parentRequest.getMobile());
        detailsDao.setRelation(parentRequest.getRelation());
        detailsDao.setStudentId(parentRequest.getStudentId());
        detailsDao.setCreatedDate(LocalDateTime.now());
        detailsDao.setCreatedBy(VisaCommonConstants.SYSTEM);
        detailsDao.setUpdatedDate(LocalDateTime.now());
        detailsDao.setUpdatedBy(VisaCommonConstants.SYSTEM);
        return detailsDao;
    }

    private ParentResponse convertParentDetailsDAOToResponse(ParentDetailsDao parentDao){
        ParentResponse parentResponse = new ParentResponse();
        ParentResponseDetail detailsDao = new ParentResponseDetail();
        detailsDao.setId(parentDao.getId());
        detailsDao.setAlternateMobile(parentDao.getAlternateMobile());
        detailsDao.setEmail(parentDao.getEmail());
        detailsDao.setFirstName(parentDao.getFirstName());
        detailsDao.setLastName(parentDao.getLastName());
        detailsDao.setMiddleName(parentDao.getMiddleName());
        detailsDao.setMobile(parentDao.getMobile());
        detailsDao.setRelation(parentDao.getRelation());
        detailsDao.setStudentId(parentDao.getStudentId());
        detailsDao.setCreatedDate(LocalDateTime.now());
        detailsDao.setCreatedBy(VisaCommonConstants.SYSTEM);
        detailsDao.setUpdatedDate(LocalDateTime.now());
        detailsDao.setUpdatedBy(VisaCommonConstants.SYSTEM);
        parentResponse.setData(detailsDao);
        parentResponse.setResult(utility.getSuccessResponse());
        return parentResponse;
    }
}
