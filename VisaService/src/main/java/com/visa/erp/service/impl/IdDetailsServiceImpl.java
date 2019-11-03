package com.visa.erp.service.impl;

import com.visa.erp.DAO.IdDetailsDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.enums.IDTypes;
import com.visa.erp.model.IdDetail;
import com.visa.erp.model.IdDetailsRequest;
import com.visa.erp.model.IdDetailsResponse;
import com.visa.erp.model.IdDetailsResponseDetail;
import com.visa.erp.repository.IdDetailsRepository;
import com.visa.erp.service.IdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class IdDetailsServiceImpl implements IdDetailsService {

    @Autowired
    private IdDetailsRepository idDetailsRepository;

    @Autowired
    private CommonUtility commonUtility;

    private static final Logger log = Logger.getLogger(IdDetailsServiceImpl.class.getName());

    @Override
    public IdDetailsResponse findByStudentId(Long id) {
        List<IdDetailsDao> idDetailsDao = idDetailsRepository.findAllByStudentId(id);
        if (idDetailsDao == null || idDetailsDao.size() < 1) {
            log.info("IdDetailsDao are not found");
        } else {
            idDetailsDao.stream().forEach(idDetailsDao1 -> log.info("IdDetailsDao log : {}" + idDetailsDao1));
        }
        return convertIdDetailsDaoToResponse(idDetailsDao, id);
    }

    @Override
    public IdDetailsResponse save(IdDetailsRequest idDetailsRequest) {
        //List<IdDetailsDao> idDetailsDao = convertIdDetailsRequestToDao(idDetailsRequest);
        IdDetailsDao idDetailsDao = convertIdDetailsRequestToDao(idDetailsRequest);
        idDetailsDao = idDetailsRepository.save(idDetailsDao);

        List<IdDetailsDao> idDetailsDaoList = new ArrayList<IdDetailsDao>();
        idDetailsDaoList.add(idDetailsDao);

        return convertIdDetailsDaoToResponse(idDetailsDaoList, idDetailsRequest.getStudentId());
    }

    private IdDetailsDao convertIdDetailsRequestToDao(IdDetailsRequest idDetailsRequest) {
        //List<IdDetailsDao> idDetailsDaoList = new ArrayList<IdDetailsDao>();
        //List<IdDetail> idDetails = idDetailsRequest.getIdDetails();
        IdDetailsDao idDetailDao = new IdDetailsDao();
        idDetailDao.setStudentId(idDetailsRequest.getStudentId());
        idDetailDao.setIdType(idDetailsRequest.getIdType());
        idDetailDao.setIdNumber(idDetailsRequest.getIdNumber());
        idDetailDao.setIdIssueDate(CommonUtility.strToDate(idDetailsRequest.getIdIssueDate()));
        idDetailDao.setIdExpiryDate(CommonUtility.strToDate(idDetailsRequest.getIdExpiryDate()));
        idDetailDao.setCountryOfIssue(idDetailsRequest.getCountryOfIssue());
        /*if (!idDetails.isEmpty()) {
            idDetails.stream().forEach(idDetail -> {
                        IdDetailsDao idDetailDao = new IdDetailsDao();
                        idDetailDao.setStudentId(idDetailsRequest.getStudentId());
                        idDetailDao.setIdType(idDetail.getIdType());
                        idDetailDao.setIdNumber(idDetail.getIdNumber());
                        idDetailDao.setIdIssueDate(CommonUtility.strToDate(idDetail.getIdIssueDate()));
                        idDetailDao.setIdExpiryDate(CommonUtility.strToDate(idDetail.getIdExpiryDate()));
                        idDetailDao.setCountryOfIssue(idDetail.getCountryOfIssue());
                        idDetailsDaoList.add(idDetailDao);
                    }
            );
        }*/
        return idDetailDao;
    }

    private IdDetailsResponse convertIdDetailsDaoToResponse(List<IdDetailsDao> idDetailsDao, Long studentId) {
        IdDetailsResponse idDetailsResponse = new IdDetailsResponse();
        IdDetailsResponseDetail idDetailsResponseDetail = new IdDetailsResponseDetail();
        List<IdDetail> idDetails = new ArrayList<>();
        if (idDetailsDao == null || idDetailsDao.size() < 1) {
            log.info("IdDetailsDao2 are not found");
        } else {
            idDetailsDao.stream().forEach(idDetailDao -> {
                        IdDetail idDetail = new IdDetail();
                        idDetail.setIdType(idDetailDao.getIdType());
                        idDetail.setIdNumber(idDetailDao.getIdNumber());
                        idDetail.setIdIssueDate(idDetailDao.getIdIssueDate().toString());
                        idDetail.setIdExpiryDate(idDetailDao.getIdExpiryDate().toString());
                        idDetail.setCountryOfIssue(idDetailDao.getCountryOfIssue());
                        if (idDetailDao.getIdType() == IDTypes.Passport.getId())
                            idDetail.setPassport(true);
                        else idDetail.setPassport(false);
                        idDetails.add(idDetail);
                    }
            );
        }
        idDetailsResponseDetail.setIdDetails(idDetails);
        idDetailsResponseDetail.setStudentId(studentId);
        idDetailsResponse.setResult(commonUtility.noRecordsFound());
        return idDetailsResponse;
    }
}