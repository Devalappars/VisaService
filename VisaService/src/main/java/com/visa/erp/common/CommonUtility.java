package com.visa.erp.common;

import com.visa.erp.model.Result;
import org.springframework.stereotype.Component;

@Component
public class CommonUtility {

    public Result getSuccessResponse(){
        Result result = new Result("0","Success");
        return result;
    }
}
