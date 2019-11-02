package com.visa.erp.common;

import com.visa.erp.model.Result;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class CommonUtility {

    public Result getSuccessResponse(){
        Result result = new Result("0","Success");
        return result;
    }

    public Result noRecordsFound(){
        Result result = new Result("-1","No Records Found");
        return result;
    }

    public static LocalDateTime strToDate(String str) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(str,formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
