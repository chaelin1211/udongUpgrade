package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOARD")
public class BoardBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer POSTNUM;
    int CATEGORY_NUM;
    String TIME;
    String TITLE;
    String CONTENT;
    Integer RECOMMEND;
    String EMAIL;
    String NICKNAME;


    public BoardBean() {
        RECOMMEND=0;
    }

    public BoardBean(Integer POSTNUM, int CATEGORY_NUM, String TIME, String TITLE, String CONTENT, Integer RECOMMEND, String EMAIL, String NICKNAME) {
        this.POSTNUM = POSTNUM;
        this.CATEGORY_NUM = CATEGORY_NUM;
        this.TIME = TIME;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.RECOMMEND = RECOMMEND;
        this.EMAIL = EMAIL;
        this.NICKNAME = NICKNAME;
    }

    public Integer getPOSTNUM() {
        return this.POSTNUM;
    }

    public void setPOSTNUM(Integer POSTNUM) {
        this.POSTNUM = POSTNUM;
    }

    public int getCATEGORY() {
        return this.CATEGORY_NUM;
    }

    public void setCATEGORY(int CATEGORY_NUM) {
        this.CATEGORY_NUM = CATEGORY_NUM;
    }

    public String getTIME() {
        return this.TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getTITLE() {
        return this.TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCONTENT() {
        return this.CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public Integer getRECOMMEND() {
        return this.RECOMMEND;
    }

    public void setRECOMMEND(Integer RECOMMEND) {
        this.RECOMMEND = RECOMMEND;
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

    public BoardBean POSTNUM(Integer POSTNUM) {
        this.POSTNUM = POSTNUM;
        return this;
    }
    

    public BoardBean CATEGORY(int CATEGORY_NUM) {
        this.CATEGORY_NUM = CATEGORY_NUM;
        return this;
    }

    public BoardBean TIME(String TIME) {
        this.TIME = TIME;
        return this;
    }

    public BoardBean TITLE(String TITLE) {
        this.TITLE = TITLE;
        return this;
    }

    public BoardBean CONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
        return this;
    }

    public BoardBean RECOMMEND(Integer RECOMMEND) {
        this.RECOMMEND = RECOMMEND;
        return this;
    }

    public BoardBean EMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
        return this;
    }

    public BoardBean NICKNAME(String NICKNAME){
        this.NICKNAME = NICKNAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BoardBean)) {
            return false;
        }
        BoardBean boardBean = (BoardBean) o;
        return Objects.equals(POSTNUM, boardBean.POSTNUM) && Objects.equals(CATEGORY_NUM, boardBean.CATEGORY_NUM) && Objects.equals(TIME, boardBean.TIME) && Objects.equals(TITLE, boardBean.TITLE) && Objects.equals(CONTENT, boardBean.CONTENT) && Objects.equals(RECOMMEND, boardBean.RECOMMEND) && Objects.equals(EMAIL, boardBean.EMAIL) && Objects.equals(NICKNAME, boardBean.NICKNAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POSTNUM, CATEGORY_NUM, TIME, TITLE, CONTENT, RECOMMEND, EMAIL);
    }

    @Override
    public String toString() {
        return "{" +
            " POSTNUM='" + getPOSTNUM() + "'" +
            ", CATEGORY_NUM='" + getCATEGORY() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", RECOMMEND='" + getRECOMMEND() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            ", NICKNAME='" + getNICKNAME()+"'"+
            "}";
    }

}