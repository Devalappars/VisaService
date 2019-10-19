package com.visa.erp.exception;

import javax.servlet.http.HttpServletRequest;

import com.visa.erp.constant.CommonConstants;
import com.visa.erp.model.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("za.co.hellogroup.productpricing.controller")
public class MyExceptionHandler {
      
	  private Log logger=LogFactory.getLog(MyExceptionHandler.class);
	  @ExceptionHandler
	  public ResponseEntity<Result> productNotAvailable(HttpServletRequest req, NullPointerException ex){
			 logger.error("Request : "+ req.getRequestURL() + "raised" + ex);
			 Result result=new Result(CommonConstants.NOT_FOUND_CODE, CommonConstants.NOT_FOUND_DESC);
			 return new ResponseEntity<Result>(result,HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler
	  public ResponseEntity<Result> productNotAvailableIndex(HttpServletRequest req,IndexOutOfBoundsException ex){
			 logger.error("Request : "+ req.getRequestURL() + "raised" + ex);
			 Result result=new Result(CommonConstants.NOT_FOUND_CODE, CommonConstants.NOT_FOUND_DESC);
			 return new ResponseEntity<Result>(result,HttpStatus.NOT_FOUND);
	  }
	  
}

