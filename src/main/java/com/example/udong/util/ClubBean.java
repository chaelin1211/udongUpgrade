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
    String AREA_NAME;
    String CONTENT;
    String ID;
    String INTEREST;
    Integer RECOMMEND;
    

    public ClubBean() {
    }

    public ClubBean(String CLUB_NAME, String INTRO, String AREA_NAME, String CONTENT, String ID, Integer CLUB_NUM, String INTEREST, Integer RECOMMEND) {
        this.CLUB_NAME = CLUB_NAME;
        this.INTRO = INTRO;
        this.AREA_NAME = AREA_NAME;
        this.CONTENT = CONTENT;
        this.ID = ID;
        this.CLUB_NUM = CLUB_NUM;
        this.INTEREST = INTEREST;
        this.RECOMMEND = RECOMMEND;
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

    public String getAREA_NAME() {
        return this.AREA_NAME;
    }

    public void setAREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
    }

    public String getCONTENT() {
        return this.CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public String getINTEREST() {
        return this.INTEREST;
    }

    public void setINTEREST(String INTEREST) {
        this.INTEREST = INTEREST;
    }

    public Integer getRECOMMEND() {
        return this.RECOMMEND;
    }

    public void setRECOMMEND(Integer RECOMMEND) {
        this.RECOMMEND = RECOMMEND;
    }

    public ClubBean CLUB_NAME(String CLUB_NAME) {
        this.CLUB_NAME = CLUB_NAME;
        return this;
    }

    public ClubBean INTRO(String INTRO) {
        this.INTRO = INTRO;
        return this;
    }

    public ClubBean AREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
        return this;
    }

    public ClubBean CONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
        return this;
    }

    public ClubBean ID(String ID) {
        this.ID = ID;
        return this;
    }

    public ClubBean CLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        return this;
    }

    public ClubBean INTEREST(String INTEREST) {
        this.INTEREST = INTEREST;
        return this;
    }

    public ClubBean RECOMMEND(Integer RECOMMEND) {
        this.RECOMMEND = RECOMMEND;
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
        return Objects.equals(CLUB_NAME, clubBean.CLUB_NAME) && Objects.equals(INTRO, clubBean.INTRO) && Objects.equals(AREA_NAME, clubBean.AREA_NAME) && Objects.equals(CONTENT, clubBean.CONTENT) && Objects.equals(ID, clubBean.ID) && Objects.equals(CLUB_NUM, clubBean.CLUB_NUM) && Objects.equals(INTEREST, clubBean.INTEREST) && Objects.equals(RECOMMEND, clubBean.RECOMMEND);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLUB_NAME, INTRO, AREA_NAME, CONTENT, ID, CLUB_NUM, INTEREST, RECOMMEND);
    }

    @Override
    public String toString() {
        return "{" +
            " CLUB_NAME='" + getCLUB_NAME() + "'" +
            ", INTRO='" + getINTRO() + "'" +
            ", AREA_NAME='" + getAREA_NAME() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", ID='" + getID() + "'" +
            ", CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", INTEREST='" + getINTEREST() + "'" +
            ", RECOMMEND='" + getRECOMMEND() + "'" +
            "}";
    }


}