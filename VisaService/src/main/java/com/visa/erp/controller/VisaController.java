package com.visa.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.QueryParam;

import com.visa.erp.DTO.VisaDTO;
import com.visa.erp.constant.CommonConstants;
import com.visa.erp.model.BasicResponse;
import com.visa.erp.model.Category;
import com.visa.erp.model.FeeDetail;
import com.visa.erp.model.Result;
import com.visa.erp.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/visa/api/1.0.0")
public class VisaController extends Throwable {

	private static final Logger log = Logger.getLogger(VisaController.class.getName());

	@Autowired
	private VisaService visaService;

	@GetMapping(path = "/getProductPriceList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getPricingList(@QueryParam("productTag") String productTag) {

		List<Category> list = null;
		Category productCategory = null;
			if (productTag == null)
				list = visaService.getAllProductwithPrices();
			else {
				productCategory = visaService.getProductByTag(productTag);
				list = new ArrayList<Category>();
				if(list!=null)
				list.add(productCategory);
			 }
			log.info("list of product :: " + list.toString());
		    return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	
   
	@GetMapping(path = {"/price/priceByProductTag/{productTag}","/price/priceByProductTag/{productTag}/{amount}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicResponse> getPrice(@PathVariable("productTag") String productTag,
                                                  @QueryParam("transactionType") String transactionType, @QueryParam("accountType") String accountType,
                                                  @PathVariable(required = false , name="amount") String amount) {
		String ttNumber = null;
		String ftNumber = null;
		BasicResponse basicResponse = new BasicResponse();
		String amt= (StringUtils.isEmpty(amount))? CommonConstants.DEFAULT_AMOUNT : amount ;
		log.info("amount :"+Float.valueOf(amt));
		if(Float.valueOf(amt) >= 0) {
			if (transactionType == null && accountType == null) {
				log.info("when only productTag and amount is present");
				basicResponse = visaService.getPlan(productTag, accountType, amt, ttNumber, ftNumber);
			} else {
				basicResponse = visaService.getFeeService(productTag, transactionType, accountType, amt, ttNumber, ftNumber);
			}
		}else{
			FeeDetail feeDetail = new FeeDetail(Float.valueOf(amount),CommonConstants.DEFAULT_FLOAT_VALUE);
			Result result=new Result(CommonConstants.BAD_REQUEST_CODE,CommonConstants.BAD_REQUEST_DESC);
            basicResponse.setResult(result);
            basicResponse.setData(feeDetail);
		}
		return new ResponseEntity<>(basicResponse, HttpStatus.OK);
	}

	@GetMapping(path = {"/price/priceByTTNumber/{ttNumber}","/price/priceByTTNumber/{ttNumber}/{amount}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicResponse> getPriceByTTNumber(@PathVariable("ttNumber") String ttNumber,
															@PathVariable(required = false , name="amount") String amount,
															@QueryParam("transactionType") String transactionType,
			                                                @QueryParam("accountType") String accountType) {
		String productTag = null;
		String ftNumber = null;
		BasicResponse basicResponse = new BasicResponse();
		log.info("product TTNumber :: " + ttNumber);
		String amt= (StringUtils.isEmpty(amount)) ? CommonConstants.DEFAULT_AMOUNT  : amount ;
		log.info("amount :"+Float.valueOf(amt));
		if(Float.valueOf(amt) >= 0) {
		if (transactionType == null && accountType == null) {
			log.info("when only productTag and amount is present");
			basicResponse = visaService.getPlan(productTag, accountType, amt, ttNumber, ftNumber);
		} else
			basicResponse = visaService.getFeeService(productTag, transactionType, accountType, amt, ttNumber,ftNumber);
		}else{
			FeeDetail feeDetail = new FeeDetail(Float.valueOf(amount),CommonConstants.DEFAULT_FLOAT_VALUE);
			Result result=new Result(CommonConstants.BAD_REQUEST_CODE,CommonConstants.BAD_REQUEST_DESC);
			basicResponse.setResult(result);
			basicResponse.setData(feeDetail);
		}
	    return new ResponseEntity<>(basicResponse, HttpStatus.OK);
	}

	@GetMapping(path = {"/price/priceByFTNumber/{ftNumber}","/price/priceByFTNumber/{ftNumber}/{amount}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicResponse> getPriceByFTNumber(@PathVariable("ftNumber") String ftNumber,
															@PathVariable(required = false , name="amount") String amount,
															@QueryParam("transactionType") String transactionType,
															@QueryParam("accountType") String accountType) {
		String productTag = null;
		String ttNumber = null;
		BasicResponse basicResponse = new BasicResponse();
		String amt= (StringUtils.isEmpty(amount))? CommonConstants.DEFAULT_AMOUNT : amount ;
		log.info("amount :"+Float.valueOf(amt));
		if(Float.valueOf(amt) >= 0) {
			if (transactionType == null && accountType == null) {
				log.info("when only productTag and amount is present");
				basicResponse = visaService.getPlan(productTag, accountType, amt, ttNumber, ftNumber);
			} else {
				basicResponse = visaService.getFeeService(productTag, transactionType, accountType, amt, ttNumber,
						ftNumber);
			}
    	}else{
			FeeDetail feeDetail = new FeeDetail(Float.valueOf(amount),CommonConstants.DEFAULT_FLOAT_VALUE);
			Result result=new Result(CommonConstants.BAD_REQUEST_CODE,CommonConstants.BAD_REQUEST_DESC);
			basicResponse.setResult(result);
			basicResponse.setData(feeDetail);
		}
		return new ResponseEntity<>(basicResponse, HttpStatus.OK);
	}
	
	@PutMapping(path = "/price/updatePlanByProductTag/{productTag}/{transactionType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> updatePlanByTag(@PathVariable("productTag")String productTag,@PathVariable("transactionType")String transactionType, @RequestBody VisaDTO pricingPlan){
		Result result;
		result= visaService.updatePlan(productTag, transactionType, pricingPlan);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}
	
}
