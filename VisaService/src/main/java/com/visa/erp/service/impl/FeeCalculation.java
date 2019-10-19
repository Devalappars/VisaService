package com.visa.erp.service.impl;

import java.util.logging.Logger;

import com.visa.erp.constant.CommonConstants;
import com.visa.erp.model.PricingPlan;

public class FeeCalculation {
	private static final Logger log = Logger.getLogger(FeeCalculation.class.getName());
	CommonConstants commonConstant = new CommonConstants();
	
	@SuppressWarnings("unused")
	public double amountCalculation(PricingPlan pricingPlan, String accountType, String amount)
	{
		double fee = 0;
		String accountTypeIndividual="Individual";
		String accountTypeStaff="Staff";
		float variableFee=0;
		double proportionCorrect =0;
		double indFixedFee, indVariableFee, staffFixedFee, staffVariableFee;
		log.info("pricingPlan :: "+pricingPlan.getIndividualFixedFee() + ":: indVariableFee" +pricingPlan.getIndividualVariableFee() +":: staffFixedFee "+pricingPlan.getStaffFixedFee() + ":: amount"+amount);
		log.info("AccountType :: "+accountType);
		if(accountType!=null){
				if(accountType.equalsIgnoreCase(accountTypeIndividual)){
					
					indFixedFee = pricingPlan.getIndividualFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualFixedFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
					indVariableFee = pricingPlan.getIndividualVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualVariableFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
					proportionCorrect=Double.parseDouble(amount)*(indVariableFee/100);
					log.info("proportion calculated amount  :: " +proportionCorrect);
					fee=indFixedFee+proportionCorrect;
					log.info("calculated amount :: "+fee);
					
				}else if (accountType.equalsIgnoreCase(accountTypeStaff)) {
					
					staffVariableFee = pricingPlan.getStaffVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getStaffVariableFee() : CommonConstants.DEFAULT_FLOAT_VALUE ;
					staffFixedFee = pricingPlan.getStaffFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getStaffFixedFee() : CommonConstants.DEFAULT_FLOAT_VALUE ;
					proportionCorrect=Double.parseDouble(amount)*(staffVariableFee/100);
					log.info("proportion calculated amount  :: " +proportionCorrect);
					fee=staffFixedFee+proportionCorrect;
					log.info("calculated amount :: "+fee);
				}else{
					log.info("account type doesnt match");
					fee=-1;
				}					
		 }else {
			 if((pricingPlan.getIndividualFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE || pricingPlan.getIndividualVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE) &&
				(pricingPlan.getStaffFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE || pricingPlan.getStaffVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE )){
				    
				 indFixedFee = pricingPlan.getIndividualFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualFixedFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
				 indVariableFee = pricingPlan.getIndividualVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualVariableFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
				 proportionCorrect=Double.parseDouble(amount)*(indVariableFee/100);
				 log.info("proportion calculated amount  :: " +proportionCorrect);
				 fee=indFixedFee+proportionCorrect;
				 log.info(" when both the account type value is present calculated amount :: "+fee);
	
			 }else if((pricingPlan.getIndividualFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE || pricingPlan.getIndividualVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE) &&
					  (pricingPlan.getStaffFixedFee()==CommonConstants.DEFAULT_FLOAT_VALUE && pricingPlan.getStaffVariableFee()==CommonConstants.DEFAULT_FLOAT_VALUE)){
				      
				indFixedFee = pricingPlan.getIndividualFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualFixedFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
				indVariableFee = pricingPlan.getIndividualVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getIndividualVariableFee() : CommonConstants.DEFAULT_FLOAT_VALUE;
				proportionCorrect=Double.parseDouble(amount)*(indVariableFee/100);
				log.info("proportion calculated amount for individual transaction type  :: " +proportionCorrect);
				fee=indFixedFee+proportionCorrect;
				log.info("calculated amount :: "+fee);
				
			}else if((pricingPlan.getStaffFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE || pricingPlan.getStaffVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE) &&
					((pricingPlan.getIndividualFixedFee()==CommonConstants.DEFAULT_FLOAT_VALUE && pricingPlan.getIndividualVariableFee()==CommonConstants.DEFAULT_FLOAT_VALUE))){
				
				staffVariableFee = pricingPlan.getStaffVariableFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getStaffVariableFee() : CommonConstants.DEFAULT_FLOAT_VALUE ;
				staffFixedFee = pricingPlan.getStaffFixedFee()!=CommonConstants.DEFAULT_FLOAT_VALUE ? pricingPlan.getStaffFixedFee() : CommonConstants.DEFAULT_FLOAT_VALUE ;
				proportionCorrect=Double.parseDouble(amount)*(staffVariableFee/100);
				log.info("proportion calculated amount for external transaction type  :: " +proportionCorrect);
				fee=staffFixedFee+proportionCorrect;
				log.info("calculated amount :: "+fee);
		    }else
				log.info("Request for price calculation  is not correct");
		 }		
		log.info("calculated amount :: "+fee);
		return fee;
		}
	}

