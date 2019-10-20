package com.visa.erp.service;

import java.util.List;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;

import com.visa.erp.DTO.VisaDTO;
import com.visa.erp.constant.CommonConstants;
import com.visa.erp.model.BasicResponse;
import com.visa.erp.model.Category;
import com.visa.erp.model.Result;


public interface VisaService {
	

	
	@Cached(name="productsList" , cacheType=CacheType.REMOTE, expire=CommonConstants.REDIS_KEY_EXPIRY)
	List<Category> getAllProductwithPrices();
	Category getProductByTag(String productTag);
	BasicResponse getFeeService( String productTag, String transactionType, String accountType, String amount, String ttNumber ,String ftNumber);
    BasicResponse getPlan(String productTag,String accountType, String amount, String ttNumber,String ftNumber);
    Result updatePlan(String productTag, String transactionType, VisaDTO visaDTO);

}
