package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class MemberBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    String USER_ID;
    String NICKNAME;
    Integer BIRTH_MONTH;
    Integer BIRTH_DAY;
    Integer AREA_NUM;
    Integer GRADE;

    public MemberBean(String USER_ID, String NICKNAME, Integer BIRTH_MONTH, Integer BIRTH_DAY, Integer AREA_NUM, Integer GRADE) {
        this.USER_ID = USER_ID;
        this.NICKNAME = NICKNAME;
        this.BIRTH_MONTH = BIRTH_MONTH;
        this.BIRTH_DAY = BIRTH_DAY;
        this.AREA_NUM = AREA_NUM;
        this.GRADE = GRADE;
    }

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNICKNAME() {
        return this.NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
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

    public MemberBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
        return this;
    }

    public MemberBean NICKNAME(String NICKNAME) {
        setNICKNAME(NICKNAME);
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
        return Objects.equals(USER_ID, memberBean.USER_ID) && Objects.equals(NICKNAME, memberBean.NICKNAME) && Objects.equals(BIRTH_MONTH, memberBean.BIRTH_MONTH) && Objects.equals(BIRTH_DAY, memberBean.BIRTH_DAY) && Objects.equals(AREA_NUM, memberBean.AREA_NUM) && Objects.equals(GRADE, memberBean.GRADE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, NICKNAME, BIRTH_MONTH, BIRTH_DAY, AREA_NUM, GRADE);
    }

    @Override
    public String toString() {
        return "{" +
            " USER_ID='" + getUSER_ID() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            ", BIRTH_MONTH='" + getBIRTH_MONTH() + "'" +
            ", BIRTH_DAY='" + getBIRTH_DAY() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            ", GRADE='" + getGRADE() + "'" +
            "}";
    }

    public MemberBean() {
        this.GRADE = 2;
    }
}