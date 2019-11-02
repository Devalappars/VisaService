package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class IdDetailsRequest {

    @SerializedName("studentId")
    private Long studentId;

    @SerializedName("idDetails")
    private List<IdDetail> idDetails;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public List<IdDetail> getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(List<IdDetail> idDetails) {
        this.idDetails = idDetails;
    }
}