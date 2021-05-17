package com.example.udong.util;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class MemberBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    String EMAIL;

    public MemberBean() {
        this.GRADE = 2;
    }

    public MemberBean(String EMAIL, String NAME, Integer BIRTH_MONTH, Integer BIRTH_DAY, Integer AREA_NUM, Integer GRADE) {
        this.EMAIL = EMAIL;
        this.NAME = NAME;
        this.BIRTH_MONTH = BIRTH_MONTH;
        this.BIRTH_DAY = BIRTH_DAY;
        this.AREA_NUM = AREA_NUM;
        this.GRADE = GRADE;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getBIRTH_MONTH() {
        return this.BIRTH_MONTH;
    }

    public void setBIRTH_MONTH(Integer BIRTH_MONTH) {
        this.BIRTH_MONTH = BIRTH_MONTH;
    }

    public Integer getBIRTH_DAY() {
        return this.BIRTH_DAY;
    }

    public void setBIRTH_DAY(Integer BIRTH_DAY) {
        this.BIRTH_DAY = BIRTH_DAY;
    }

    public Integer getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public Integer getGRADE() {
        return this.GRADE;
    }

    public void setGRADE(Integer GRADE) {
        this.GRADE = GRADE;
    }

    public MemberBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
        return this;
    }

    public MemberBean NAME(String NAME) {
        setNAME(NAME);
        return this;
    }

    public MemberBean BIRTH_MONTH(Integer BIRTH_MONTH) {
        setBIRTH_MONTH(BIRTH_MONTH);
        return this;
    }

    public MemberBean BIRTH_DAY(Integer BIRTH_DAY) {
        setBIRTH_DAY(BIRTH_DAY);
        return this;
    }

    public MemberBean AREA_NUM(Integer AREA_NUM) {
        setAREA_NUM(AREA_NUM);
        return this;
    }

    public MemberBean GRADE(Integer GRADE) {
        setGRADE(GRADE);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MemberBean)) {
            return false;
        }
        MemberBean memberBean = (MemberBean) o;
        return Objects.equals(EMAIL, memberBean.EMAIL) && Objects.equals(NAME, memberBean.NAME) && Objects.equals(BIRTH_MONTH, memberBean.BIRTH_MONTH) && Objects.equals(BIRTH_DAY, memberBean.BIRTH_DAY) && Objects.equals(AREA_NUM, memberBean.AREA_NUM) && Objects.equals(GRADE, memberBean.GRADE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EMAIL, NAME, BIRTH_MONTH, BIRTH_DAY, AREA_NUM, GRADE);
    }

    @Override
    public String toString() {
        return "{" +
            " EMAIL='" + getEMAIL() + "'" +
            ", NAME='" + getNAME() + "'" +
            ", BIRTH_MONTH='" + getBIRTH_MONTH() + "'" +
            ", BIRTH_DAY='" + getBIRTH_DAY() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            ", GRADE='" + getGRADE() + "'" +
            "}";
    }
    String NAME;
    Integer BIRTH_MONTH;
    Integer BIRTH_DAY;
    Integer AREA_NUM;
    Integer GRADE;
}