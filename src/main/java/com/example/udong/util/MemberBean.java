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
    String NAME;
    String GENDER;
    Integer BIRTH_YEAR;
    Integer BIRTH_MONTH;
    Integer BIRTH_DAY;
    String NICKNAME;
    Integer AREA_NUM;

    public MemberBean() {
    }

    public MemberBean(String EMAIL, String NAME, String GENDER, Integer BIRTH_YEAR, Integer BIRTH_MONTH, Integer BIRTH_DAY, String NICKNAME, Integer AREA_NUM) {
        this.EMAIL = EMAIL;
        this.NAME = NAME;
        this.GENDER = GENDER;
        this.BIRTH_YEAR = BIRTH_YEAR;
        this.BIRTH_MONTH = BIRTH_MONTH;
        this.BIRTH_DAY = BIRTH_DAY;
        this.NICKNAME = NICKNAME;
        this.AREA_NUM = AREA_NUM;
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

    public String getGENDER() {
        return this.GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public Integer getBIRTH_YEAR() {
        return this.BIRTH_YEAR;
    }

    public void setBIRTH_YEAR(Integer BIRTH_YEAR) {
        this.BIRTH_YEAR = BIRTH_YEAR;
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

    public String getNICKNAME() {
        return this.NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public Integer getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public MemberBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
        return this;
    }

    public MemberBean NAME(String NAME) {
        setNAME(NAME);
        return this;
    }

    public MemberBean GENDER(String GENDER) {
        setGENDER(GENDER);
        return this;
    }

    public MemberBean BIRTH_YEAR(Integer BIRTH_YEAR) {
        setBIRTH_YEAR(BIRTH_YEAR);
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

    public MemberBean NICKNAME(String NICKNAME) {
        setNICKNAME(NICKNAME);
        return this;
    }

    public MemberBean AREA_NUM(Integer AREA_NUM) {
        setAREA_NUM(AREA_NUM);
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
        return Objects.equals(EMAIL, memberBean.EMAIL) && Objects.equals(NAME, memberBean.NAME) && Objects.equals(GENDER, memberBean.GENDER) && Objects.equals(BIRTH_YEAR, memberBean.BIRTH_YEAR) && Objects.equals(BIRTH_MONTH, memberBean.BIRTH_MONTH) && Objects.equals(BIRTH_DAY, memberBean.BIRTH_DAY) && Objects.equals(NICKNAME, memberBean.NICKNAME) && Objects.equals(AREA_NUM, memberBean.AREA_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EMAIL, NAME, GENDER, BIRTH_YEAR, BIRTH_MONTH, BIRTH_DAY, NICKNAME, AREA_NUM);
    }

    @Override
    public String toString() {
        return "{" +
            " EMAIL='" + getEMAIL() + "'" +
            ", NAME='" + getNAME() + "'" +
            ", GENDER='" + getGENDER() + "'" +
            ", BIRTH_YEAR='" + getBIRTH_YEAR() + "'" +
            ", BIRTH_MONTH='" + getBIRTH_MONTH() + "'" +
            ", BIRTH_DAY='" + getBIRTH_DAY() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            "}";
    }


}