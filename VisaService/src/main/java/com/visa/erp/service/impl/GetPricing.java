package com.visa.erp.service.impl;

import java.util.Set;
import java.util.logging.Logger;

import com.visa.erp.DAO.PricingProduct;
import com.visa.erp.model.BasicResponse;


public class GetPricing {
	
	
	
	private static final Logger log = Logger.getLogger("GetPricing");
	
	@SuppressWarnings({ "null", "unused" })
	public BasicResponse retrievePricingPlan(Set<PricingProduct> pricingProduct, String accountType, String amount ){
		BasicResponse basicResponse=null;
		/*PricingPlans pricingPlanDAO=(((PricingProduct) pricingProduct).getPricingProductMapping()).getPricingPlans();
		Result result=null;
		FeeDetail feeDetail=null;
		float fee=0;
		PricingPlan pricingPlan=new PricingPlan();
		PricingProduct pricingProducts=null;
		AccountTypeValidation accountTypeValidation=new AccountTypeValidation();
		FeeCalculation calculate=new FeeCalculation();
		pricingPlan=new PricingPlan(pricingPlanDAO.getId(), pricingPlanDAO.getIndFixedFee(), pricingPlanDAO.getIndVariableFee(), pricingPlanDAO.getStaffFixedFee(), pricingPlanDAO.getStaffVariableFee());
		if(null != pricingProduct)
			pricingProducts = new PricingProduct(pricingProduct.getId(), pricingProduct.getProductTT(), pricingProduct.getProductTag(),pricingProduct.getFtNumber(),pricingProduct.getCorpAccount() ,pricingProduct.getTransactionDesc(), pricingPlan,pricingProduct.getPricingProductMapping().getTranstionType());
		else
			pricingProducts =  new PricingProduct(0,null,null,null,null,null, pricingPlan,pricingProduct.getPricingProductMapping().getTranstionType());
		if(pricingPlan!=null){
			 if(accountTypeValidation.accountTypeValidation(pricingPlan,accountType)){
		    		log.info("is valid accountType :: "+accountTypeValidation.accountTypeValidation(pricingPlan,accountType));
		
				fee=calculate.amountCalculation(pricingPlan,accountType, amount);
				feeDetail.setAmount(Float.parseFloat(amount));
		 		feeDetail.setFee(fee);
		 		basicResponse.setData(feeDetail);
		 		result=new Result("0", "Success");
		 		basicResponse.setResult(result);	
	    	 }else{
	    		
	    		result=new Result("401", "Unable to get the pricing plans");
	    		basicResponse.setResult(result);
		     }
		}*/
		return basicResponse;
	}

}
