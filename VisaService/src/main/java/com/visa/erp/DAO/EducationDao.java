package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EducationDetails")
public class EducationDao extends AbstractDAO {

    @Column(name = "StudentId")
    @JsonProperty("StudentId")
    private Long studentId;

    @Column(name = "Education")
    @JsonProperty("Education")
    private String education;

    @Column(name = "BoardOfEducation")
    @JsonProperty("BoardOfEducation")
    private String boardOfEducation;

    @Column(name = "ScoreType")
    @JsonProperty("ScoreType")
    private String scoreType;

    @Column(name = "TotalScore")
    @JsonProperty("TotalScore")
    private String totalScore;

    @Column(name = "MarksScored")
    @JsonProperty("MarksScored")
    private String marksScored;

    @Column(name = "Grade")
    @JsonProperty("Grade")
    private String grade;

    @Column(name = "YearOfCompletion")
    @JsonProperty("YearOfCompletion")
    private String yearOfCompletion;

    @Column(name = "Status")
    @JsonProperty("Status")
    private String status;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBoardOfEducation() {
        return boardOfEducation;
    }

    public void setBoardOfEducation(String boardOfEducation) {
        this.boardOfEducation = boardOfEducation;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(String marksScored) {
        this.marksScored = marksScored;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(String yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}