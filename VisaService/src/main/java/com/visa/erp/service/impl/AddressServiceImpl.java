package com.visa.erp.service.impl;

import com.visa.erp.DAO.AddressDao;
import com.visa.erp.common.CommonUtility;
import com.visa.erp.constant.VisaCommonConstants;
import com.visa.erp.model.AddressRequest;
import com.visa.erp.model.AddressResponse;
import com.visa.erp.model.AddressResponseDetail;
import com.visa.erp.repository.AddressRepository;
import com.visa.erp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public AddressResponse findByStudentId(Long id) {
        AddressDao addressDao = addressRepository.findByStudentId(id);
        if(addressDao==null){
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setResult(commonUtility.noRecordsFound());
            return null;
        }
        return convertAddressDaoToResponse(addressDao);
    }

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        AddressDao addressDao = convertAddressRequestToDao(addressRequest);
        addressDao = addressRepository.save(addressDao);
        return convertAddressDaoToResponse(addressDao);
    }

    private AddressDao convertAddressRequestToDao(AddressRequest addressRequest) {
        AddressDao addressDao = new AddressDao();
        addressDao.setStudentId(addressRequest.getStudentId());
        addressDao.setAddressType(addressRequest.getAddressType());
        addressDao.setStreetNumberOrCompleNumber(addressRequest.getStreetNumberOrCompleNumber());
        addressDao.setAddress1(addressRequest.getAddress1());
        addressDao.setAddress2(addressRequest.getAddress2());
        addressDao.setDistict(addressRequest.getDistrict());
        addressDao.setStateOrProvince(addressRequest.getStateOrProvince());
        addressDao.setCountry(addressRequest.getCountry());
        addressDao.setCreatedDate(LocalDateTime.now());
        addressDao.setCreatedBy(VisaCommonConstants.SYSTEM);
        addressDao.setUpdatedDate(LocalDateTime.now());
        addressDao.setUpdatedBy(VisaCommonConstants.SYSTEM);
        return addressDao;
    }

    private AddressResponse convertAddressDaoToResponse(AddressDao addressDao) {
        AddressResponse addressResponse = new AddressResponse();
        AddressResponseDetail addressResponseDetail = new AddressResponseDetail();
        addressResponseDetail.setStudentId(addressDao.getStudentId());
        addressResponseDetail.setAddressType(addressDao.getAddressType());
        addressResponseDetail.setStreetNumberOrCompleNumber(addressDao.getStreetNumberOrCompleNumber());
        addressResponseDetail.setAddress1(addressDao.getAddress1());
        addressResponseDetail.setAddress2(addressDao.getAddress2());
        addressResponseDetail.setDistrict(addressDao.getDistict());
        addressResponseDetail.setStateOrProvince(addressDao.getStateOrProvince());
        addressResponseDetail.setCountry(addressDao.getCountry());
        addressResponseDetail.setCreatedDate(LocalDateTime.now());
        addressResponseDetail.setCreatedBy(VisaCommonConstants.SYSTEM);
        addressResponseDetail.setUpdatedDate(LocalDateTime.now());
        addressResponseDetail.setUpdatedBy(VisaCommonConstants.SYSTEM);
        addressResponse.setData(addressResponseDetail);
        addressResponse.setResult(commonUtility.getSuccessResponse());
        return addressResponse;
    }
}