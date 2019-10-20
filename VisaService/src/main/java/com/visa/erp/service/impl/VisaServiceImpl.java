package com.visa.erp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.visa.erp.DAO.PricingProduct;
import com.visa.erp.model.*;
import com.visa.erp.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.visa.erp.DAO.PricingPlanDAO;
import com.visa.erp.DAO.PricingProductMapping;
import com.visa.erp.DAO.ProductCategory;
import com.visa.erp.DTO.VisaDTO;
import com.visa.erp.constant.CommonConstants;
import com.visa.erp.repository.CategoryWithPlans;
import com.visa.erp.repository.PricingPlansRepository;
import com.visa.erp.repository.PricingProductRepository;
import com.visa.erp.repository.ProductMappingRepository;

@Service
public class VisaServiceImpl implements VisaService {

	@Autowired
	private CategoryWithPlans categoryWithPlans;

	@Autowired
	private PricingProductRepository pricingProductRepository;
	
	@Autowired
	private PricingPlansRepository pricingPlansRepository;
	
	@Autowired
	private ProductMappingRepository productMappingRepository;

	private static final Logger log = Logger.getLogger(VisaServiceImpl.class.getName());

	@Override
	public List<Category> getAllProductwithPrices() {

		List<Category> pCategories = new ArrayList<>();
		List<ProductCategory> productCategorys = (List<ProductCategory>) categoryWithPlans.findAll();
		log.info("productCategory search :: " + productCategorys.size() + " productCategory values   :: "
				+ productCategorys.toString());
		initProductCategories(productCategorys, pCategories, null);
		log.info(pCategories.size() + " :: ");
		return pCategories;
	}

	private void initProductCategories(List<ProductCategory> productCategorys,
			List<Category> pCategories, String productTag) {
		for (ProductCategory productCategory : productCategorys) {
			// excluding those product and plans which are not been mapped
			if (CollectionUtils.isEmpty(productCategory.getPricingProductMappings()))
				continue;
			List<com.visa.erp.model.PricingProduct> pricingProducts = new ArrayList<>();
			for (PricingProductMapping pricingProductMapping : productCategory.getPricingProductMappings()) {
				PricingPlanDAO pricingPlanDAO = pricingProductMapping.getPricingPlans();
				PricingProduct pricingProduct = pricingProductMapping
						.getPricingProduct();
				if (null != productTag && !productTag.equals(pricingProduct.getProductTag()))
					continue;
				log.info("Pricing Plan :: " + pricingPlanDAO.toString());
				PricingPlan pricingPlan = new PricingPlan(pricingPlanDAO.getId(), pricingPlanDAO.getIndFixedFee(),
						pricingPlanDAO.getIndVariableFee(), pricingPlanDAO.getStaffFixedFee(),
						pricingPlanDAO.getStaffVariableFee());
				if (null != pricingProduct)
					pricingProducts.add(new com.visa.erp.model.PricingProduct(pricingProduct.getId(), pricingProduct.getProductTT(),
							pricingProduct.getProductTag(), pricingProduct.getFtNumber(),
							pricingProduct.getCorpAccount(), pricingProduct.getTransactionDesc(),
							pricingProductMapping.getTranstionType(), pricingPlan));

			}
			Category prCategoryBo = new Category(productCategory.getId(), productCategory.getCategory(), pricingProducts);
			pCategories.add(prCategoryBo);
		}

	}

	@SuppressWarnings("unused")
	@Override
	public BasicResponse getFeeService(String productTag, String transactionType, String accountType, String amount,
                                       String ttNumber, String ftNumber) {
		PricingPlan pricingPlan = null;
		PricingPlanDAO pricingPlanDAO = null;
		FeeDetail feeDetail = new FeeDetail();
		Result result = null;
		double fee = 0;
		com.visa.erp.model.PricingProduct pricingProducts = null;
		FeeCalculation calculate = new FeeCalculation();
		BasicResponse basicResponse = new BasicResponse();
		GetPricing getPricing = new GetPricing();
		int pricingProductId = 0;
		String fetchedTxnType = null;
		PricingProduct pricingProduct = null;
		try {
			if (productTag != null) {
				pricingProduct = pricingProductRepository
						.findByProductTagAndPricingProductMappingTransactionType(productTag, transactionType);
				log.info("pricing product :: " + pricingProduct.toString());
			}else if(ftNumber != null) {
				pricingProduct = pricingProductRepository
						.findByFtNumberAndPricingProductMappingTransactionType(ftNumber, transactionType);
			}else {
				pricingProduct = pricingProductRepository.findByProductTTAndPricingProductMappingTransactionType(ttNumber,
						transactionType);
				log.info("pricing product :: " + pricingProduct.toString());
			}
			for (PricingProductMapping pricingProductMapping : pricingProduct.getPricingProductMapping()) {
				fetchedTxnType = pricingProductMapping.getTranstionType();
				log.info("pricingProductMapping.getPricingPlans() ::" + pricingProductMapping.getPricingPlans());
				log.info("pricingProductMapping.getTranstionType() :: " + pricingProductMapping.getTranstionType());
				if (null != transactionType
						&& transactionType.equalsIgnoreCase(pricingProductMapping.getTranstionType())) {
					pricingPlanDAO = pricingProductMapping.getPricingPlans();
					break;
				}

			}

			log.info("pricingPlanDAO after initialization :: " + pricingPlanDAO.toString());
			if (null == pricingPlanDAO) {
				return new BasicResponse(null, new Result(CommonConstants.PLAN_NOTFOUND_CODE , 
						                         CommonConstants.PLAN_NOTFOUNT_DESC));
			}
			log.info("pricing plan fetched on the bases of product tag and transaction type"
					+ pricingPlanDAO.toString());
			pricingPlan = new PricingPlan(pricingPlanDAO.getId(), pricingPlanDAO.getIndFixedFee(),
					pricingPlanDAO.getIndVariableFee(), pricingPlanDAO.getStaffFixedFee(),
					pricingPlanDAO.getStaffVariableFee());

			log.info("pricing plan fetched on the bases of product tag and transaction type"
					+ pricingPlan.toString());
			if (pricingPlan != null && fetchedTxnType != null) {
				fee = calculate.amountCalculation(pricingPlan, accountType, amount);
				feeDetail.setAmount(Float.parseFloat(amount));
				if (fee == -1) {
					feeDetail.setFee(0);
					result = new Result(CommonConstants.ACCTYPE_NOTFOUND_CODE ,
							            CommonConstants.ACCTYPE_NOTFOUND_DESC);
				} else {
					BigDecimal bigDecimal = new BigDecimal(fee);
					BigDecimal roundedFee = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
					log.info("actual rounded fee :: " + roundedFee);
					feeDetail.setFee(roundedFee.doubleValue());
					result = new Result(CommonConstants.SUCCESS_CODE ,
							            CommonConstants.SUCCESS_DESC);
				}
				basicResponse.setData(feeDetail);
				basicResponse.setResult(result);
			}
		} catch (Exception e) {
		    log.log(Level.SEVERE, "exception in getFeeService :: "+ e.getMessage());
			basicResponse.setData(new FeeDetail(Float.parseFloat(amount), 0));
			basicResponse.setResult(new Result(CommonConstants.DATA_NOTFOUND_CODE, CommonConstants.DATA_NOTFOUND_DESC));
		}
		return basicResponse;
	}

	@Override
	@SuppressWarnings("unused")
	public BasicResponse getPlan(String productTag, String accountType, String amount, String ttNumber, String ftNumber) {
		BasicResponse basicResponse = new BasicResponse();
		FeeDetail feeDetail = new FeeDetail();
		Result result = null;
		double amountWithFee = 0;
		String acc = null;
		FeeCalculation calculate = new FeeCalculation();
		GetPricing getPricing = new GetPricing();
		List<ProductCategory> pcList = null;
		String transactionType = null;
		String txnInternalType = null;
		String txnExternalType = null;
		String planType = null;
		PricingPlan pricingPlanInternal = null;
		PricingPlan pricingPlanExternal = null;
		PricingPlan pricingPlan = new PricingPlan();
		PricingProduct pricingProduct = null;
		try {
			if (productTag != null) {
				pricingProduct = pricingProductRepository.findByProductTag(productTag);
			}else if(ftNumber != null){
				pricingProduct = pricingProductRepository.findByFtNumber(ftNumber);
			}else {
				pricingProduct = pricingProductRepository.findByProductTT(ttNumber);
			}
			for (PricingProductMapping pricingProductMapping : pricingProduct.getPricingProductMapping()) {

				PricingPlanDAO pricingPlanDAO = pricingProductMapping.getPricingPlans();
				if (pricingProductMapping.getTranstionType().equals(CommonConstants.INTERNAL_TXN)) {
					txnInternalType = pricingProductMapping.getTranstionType();
					pricingPlanInternal = new PricingPlan(pricingPlanDAO.getId(), pricingPlanDAO.getIndFixedFee(),
							pricingPlanDAO.getIndVariableFee(), pricingPlanDAO.getStaffFixedFee(),
							pricingPlanDAO.getStaffVariableFee());
				} else if (pricingProductMapping.getTranstionType().equals(CommonConstants.EXTERNAL_TXN)) {
					txnExternalType = pricingProductMapping.getTranstionType();
					pricingPlanExternal = new PricingPlan(pricingPlanDAO.getId(), pricingPlanDAO.getIndFixedFee(),
							pricingPlanDAO.getIndVariableFee(), pricingPlanDAO.getStaffFixedFee(),
							pricingPlanDAO.getStaffVariableFee());
				}
			}

			if (txnInternalType != null && txnExternalType != null) {
				transactionType = CommonConstants.EXTERNAL_TXN;
				pricingPlan = new PricingPlan(pricingPlanExternal.getPlanId(),
						pricingPlanExternal.getIndividualFixedFee(), pricingPlanExternal.getIndividualVariableFee(),
						pricingPlanExternal.getStaffFixedFee(), pricingPlanExternal.getStaffVariableFee());
			} else {
				transactionType = (txnInternalType != null) ? txnInternalType : txnExternalType;
				if (transactionType.equals(txnInternalType)) {
					pricingPlan = new PricingPlan(pricingPlanInternal.getPlanId(),
							pricingPlanInternal.getIndividualFixedFee(), pricingPlanInternal.getIndividualVariableFee(),
							pricingPlanInternal.getStaffFixedFee(), pricingPlanInternal.getStaffVariableFee());
				} else {
					pricingPlan = new PricingPlan(pricingPlanExternal.getPlanId(),
							pricingPlanExternal.getIndividualFixedFee(), pricingPlanExternal.getIndividualVariableFee(),
							pricingPlanExternal.getStaffFixedFee(), pricingPlanExternal.getStaffVariableFee());
				}
			}

			amountWithFee = calculate.amountCalculation(pricingPlan, accountType, amount);
			feeDetail.setAmount(Float.parseFloat(amount));
			BigDecimal bigDecimal = new BigDecimal(amountWithFee);
			BigDecimal roundedFee = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			log.info("actual rounded fee :: " + roundedFee);
			feeDetail.setFee(roundedFee.doubleValue());
			basicResponse.setData(feeDetail);
			result = new Result(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_DESC);
			basicResponse.setResult(result);
		} catch (Exception e) {
			log.log(Level.SEVERE, "exception in getPlan :: "+e.getMessage());
			basicResponse.setData(new FeeDetail(Float.parseFloat(amount), 0));
			if(productTag != null){
				basicResponse.setResult(new Result(CommonConstants.NOT_FOUND_CODE, CommonConstants.NOT_FOUND_DESC));
			}else if(ttNumber !=null){
				basicResponse.setResult(new Result(CommonConstants.TTNUMBER_NOTFOUND_CODE, CommonConstants.TTNUMBER_NOTFOUND_DESC));
			}else{
				basicResponse.setResult(new Result(CommonConstants.FTNUMBER_NOTFOUND_CODE, CommonConstants.FTNUMBER_NOTFOUND_DESC));
			}
		}
		return basicResponse;
	}

	@SuppressWarnings("unused")
	@Override
	public Category getProductByTag(String productTag) {
		PricingPlan pricingPlan = null;
		List<com.visa.erp.model.PricingProduct> pricingProducts = new ArrayList<>();

		PricingProduct pricingProduct = pricingProductRepository
				.findByProductTag(productTag);
		Integer productCategoryId = 0;
		for (PricingProductMapping pricingProductMapping : pricingProduct.getPricingProductMapping()) {
			productCategoryId = pricingProductMapping.getProductCategory().getId();
		}

		List<Category> pCategories = new ArrayList<>();
		Optional<ProductCategory> prOptional = categoryWithPlans.findById(productCategoryId);
		if (prOptional.isPresent() && productTag.equals(pricingProduct.getProductTag())) {
			List<ProductCategory> pcList = new ArrayList<>();
			pcList.add(prOptional.get());
			initProductCategories(pcList, pCategories, productTag);
		}
		//return CollectionUtils.isEmpty(pCategories) ? null : pCategories.get(0);
		return pCategories.get(0);
	}

	@Override
	public Result updatePlan(String productTag, String transactionType, VisaDTO visaDTO) {
		Result result=new Result();
		PricingProduct pricingProduct = pricingProductRepository.findByProductTagAndPricingProductMappingTransactionType(productTag, transactionType);
		int planID=0;
		for (PricingProductMapping pricingProductMapping : pricingProduct.getPricingProductMapping()) {
			if(pricingProductMapping.getTranstionType().equals(transactionType)){
				planID = pricingProductMapping.getPricingPlans().getId();
				break;
			}
		} 
		//check the plan is associated with multiple products or with single product 
		int number = productMappingRepository.countBypricingPlansId(planID);
		if(number==1){
		PricingPlanDAO pricingPlans=pricingPlansRepository.findById(planID);
		pricingPlans.setIndFixedFee(Float.parseFloat(visaDTO.getIndividualFixedFee()));
		pricingPlans.setIndVariableFee(Float.parseFloat(visaDTO.getIndividualVariableFee()));
		pricingPlans.setStaffFixedFee(Float.parseFloat(visaDTO.getStaffFixedFee()));
		pricingPlans.setStaffVariableFee(Float.parseFloat(visaDTO.getStaffVariableFee()));
		pricingPlansRepository.save(pricingPlans);
		log.info("Pricing Plan :: "+planID);
		log.info("Plans are with :: "+number);
		log.info("pricing product data :: "+pricingPlans);
		result.setResponseCode(CommonConstants.UPDATE_CODE);
	    result.setResponseDescription(CommonConstants.UPDATE_DESC);
		}else{
			  
		}
		result.setResponseCode("4008");
	    result.setResponseDescription("Plan is associated with more then one");
	    return result;
	}

}
