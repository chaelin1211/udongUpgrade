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
    Integer AREA_NUM;
    String CONTENT;
    String EMAIL;
    String NICKNAME;
    Integer INTEREST_NUM;
    Integer MEMBER_COUNT;

    @Override
    public String toString() {
        return "{" +
            " CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", CLUB_NAME='" + getCLUB_NAME() + "'" +
            ", INTRO='" + getINTRO() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            ", INTEREST_NUM='" + getINTEREST_NUM() + "'" +
            ", MEMBER_COUNT='" + getMEMBER_COUNT() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubBean)) {
            return false;
        }
        ClubBean clubBean = (ClubBean) o;
        return Objects.equals(CLUB_NUM, clubBean.CLUB_NUM) && Objects.equals(CLUB_NAME, clubBean.CLUB_NAME) && Objects.equals(INTRO, clubBean.INTRO) && Objects.equals(AREA_NUM, clubBean.AREA_NUM) && Objects.equals(CONTENT, clubBean.CONTENT) && Objects.equals(EMAIL, clubBean.EMAIL) && Objects.equals(NICKNAME, clubBean.NICKNAME) && Objects.equals(INTEREST_NUM, clubBean.INTEREST_NUM) && Objects.equals(MEMBER_COUNT, clubBean.MEMBER_COUNT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLUB_NUM, CLUB_NAME, INTRO, AREA_NUM, CONTENT, EMAIL, NICKNAME, INTEREST_NUM, MEMBER_COUNT);
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

    public Integer getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public String getCONTENT() {
        return this.CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNICKNAME() {
        return this.NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public Integer getINTEREST_NUM() {
        return this.INTEREST_NUM;
    }

    public void setINTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public Integer getMEMBER_COUNT() {
        return this.MEMBER_COUNT;
    }

    public void setMEMBER_COUNT(Integer MEMBER_COUNT) {
        this.MEMBER_COUNT = MEMBER_COUNT;
    }
    

    public ClubBean() {
    }

    public ClubBean(String CLUB_NAME, String NICKNAME, String INTRO, Integer AREA_NUM, String CONTENT, String EMAIL, Integer CLUB_NUM, Integer INTEREST_NUM, Integer MEMBER_COUNT) {
        this.CLUB_NAME = CLUB_NAME;
        this.INTRO = INTRO;
        this.AREA_NUM = AREA_NUM;
        this.CONTENT = CONTENT;
        this.EMAIL = EMAIL;
        this.NICKNAME = NICKNAME;
        this.CLUB_NUM = CLUB_NUM;
        this.INTEREST_NUM = INTEREST_NUM;
        this.MEMBER_COUNT = MEMBER_COUNT;
    }

    public ClubBean CLUB_NAME(String CLUB_NAME) {
        this.CLUB_NAME = CLUB_NAME;
        return this;
    }

    public ClubBean INTRO(String INTRO) {
        this.INTRO = INTRO;
        return this;
    }

    public ClubBean AREA_NAME(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
        return this;
    }

    public ClubBean CONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
        return this;
    }

    public ClubBean EMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
        return this;
    }

    public ClubBean CLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        return this;
    }

    public ClubBean NICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
        return this;
    }

    public ClubBean INTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
        return this;
    }

    public ClubBean MEMBER_COUNT(Integer MEMBER_COUNT) {
        this.MEMBER_COUNT = MEMBER_COUNT;
        return this;
    }
}