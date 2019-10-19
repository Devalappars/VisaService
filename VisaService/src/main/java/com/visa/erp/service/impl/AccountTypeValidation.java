package com.visa.erp.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.visa.erp.model.PricingPlan;

@Service
public class AccountTypeValidation {
	
	private static final Logger log = Logger.getLogger(AccountTypeValidation.class.getName());
	
	public boolean accountTypeValidation(PricingPlan pricingPlan, String accountType){
		boolean isValidAccountType=true;
		if(accountType!=null){
			isValidAccountType=true;
		}else{
			if((pricingPlan.getIndividualFixedFee()!=0.0f || pricingPlan.getIndividualVariableFee()!=0.0f) && (pricingPlan.getStaffVariableFee()!=0.0f || pricingPlan.getStaffFixedFee()!=0.0f)){
				log.info("unable to fectch the record");
				isValidAccountType=false;
			}else if((pricingPlan.getIndividualFixedFee()!=0.0f && pricingPlan.getIndividualVariableFee()!=0.0f)||(pricingPlan.getStaffFixedFee()!=0.0f && pricingPlan.getStaffVariableFee()!=0.0f)){
				isValidAccountType=true;
			}else if((pricingPlan.getIndividualFixedFee()!=0.0f && pricingPlan.getIndividualVariableFee()==0.0f)&&( pricingPlan.getStaffFixedFee()!=0.0f && pricingPlan.getStaffVariableFee()==0.0f)){
				isValidAccountType=false;
			}	
		}	
		log.info("final account validation response :: "+isValidAccountType);
		return isValidAccountType;
	}
	
	
}
