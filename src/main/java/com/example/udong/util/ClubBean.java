package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLUB")
public class ClubBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    Integer CLUB_NUM;
    String CLUB_NAME;
    String INTRO;
    String CONTENT;
    String USER_ID;
    String PIN;
    String TIME;
    Integer AREA_NUM;
    Integer INTEREST_NUM;

    public ClubBean() {
    }

    public ClubBean(Integer CLUB_NUM, String CLUB_NAME, String INTRO, String CONTENT, String USER_ID, String PIN, String TIME, Integer AREA_NUM, Integer INTEREST_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        this.CLUB_NAME = CLUB_NAME;
        this.INTRO = INTRO;
        this.CONTENT = CONTENT;
        this.USER_ID = USER_ID;
        this.PIN = PIN;
        this.TIME = TIME;
        this.AREA_NUM = AREA_NUM;
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public String getCLUB_NAME() {
        return this.CLUB_NAME;
    }

    public void setCLUB_NAME(String CLUB_NAME) {
        this.CLUB_NAME = CLUB_NAME;
    }

    public String getINTRO() {
        return this.INTRO;
    }

    public void setINTRO(String INTRO) {
        this.INTRO = INTRO;
    }

    public String getCONTENT() {
        return this.CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getPIN() {
        return this.PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getTIME() {
        return this.TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public Integer getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public Integer getINTEREST_NUM() {
        return this.INTEREST_NUM;
    }

    public void setINTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public ClubBean CLUB_NUM(Integer CLUB_NUM) {
        setCLUB_NUM(CLUB_NUM);
        return this;
    }

    public ClubBean CLUB_NAME(String CLUB_NAME) {
        setCLUB_NAME(CLUB_NAME);
        return this;
    }

    public ClubBean INTRO(String INTRO) {
        setINTRO(INTRO);
        return this;
    }

    public ClubBean CONTENT(String CONTENT) {
        setCONTENT(CONTENT);
        return this;
    }

    public ClubBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
        return this;
    }

    public ClubBean PIN(String PIN) {
        setPIN(PIN);
        return this;
    }

    public ClubBean TIME(String TIME) {
        setTIME(TIME);
        return this;
    }

    public ClubBean AREA_NUM(Integer AREA_NUM) {
        setAREA_NUM(AREA_NUM);
        return this;
    }

    public ClubBean INTEREST_NUM(Integer INTEREST_NUM) {
        setINTEREST_NUM(INTEREST_NUM);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubBean)) {
            return false;
        }
        ClubBean clubBean = (ClubBean) o;
        return Objects.equals(CLUB_NUM, clubBean.CLUB_NUM) && Objects.equals(CLUB_NAME, clubBean.CLUB_NAME) && Objects.equals(INTRO, clubBean.INTRO) && Objects.equals(CONTENT, clubBean.CONTENT) && Objects.equals(USER_ID, clubBean.USER_ID) && Objects.equals(PIN, clubBean.PIN) && Objects.equals(TIME, clubBean.TIME) && Objects.equals(AREA_NUM, clubBean.AREA_NUM) && Objects.equals(INTEREST_NUM, clubBean.INTEREST_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLUB_NUM, CLUB_NAME, INTRO, CONTENT, USER_ID, PIN, TIME, AREA_NUM, INTEREST_NUM);
    }

    @Override
    public String toString() {
        return "{" +
            " CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", CLUB_NAME='" + getCLUB_NAME() + "'" +
            ", INTRO='" + getINTRO() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", USER_ID='" + getUSER_ID() + "'" +
            ", PIN='" + getPIN() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            ", INTEREST_NUM='" + getINTEREST_NUM() + "'" +
            "}";
    }

}