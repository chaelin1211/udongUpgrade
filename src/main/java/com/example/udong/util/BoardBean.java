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
    String CATEGORY;
    String TIME;
    String TITLE;
    String CONTENT;
    Integer RECOMMEND;
    String ID;


    public BoardBean() {
        RECOMMEND=0;
    }

    public BoardBean(Integer POSTNUM, String CATEGORY, String TIME, String TITLE, String CONTENT, Integer RECOMMEND, String ID) {
        this.POSTNUM = POSTNUM;
        this.CATEGORY = CATEGORY;
        this.TIME = TIME;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.RECOMMEND = RECOMMEND;
        this.ID = ID;
    }

    public Integer getPOSTNUM() {
        return this.POSTNUM;
    }

    public void setPOSTNUM(Integer POSTNUM) {
        this.POSTNUM = POSTNUM;
    }

    public String getCATEGORY() {
        return this.CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
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

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BoardBean POSTNUM(Integer POSTNUM) {
        this.POSTNUM = POSTNUM;
        return this;
    }

    public BoardBean CATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
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

    public BoardBean ID(String ID) {
        this.ID = ID;
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
        return Objects.equals(POSTNUM, boardBean.POSTNUM) && Objects.equals(CATEGORY, boardBean.CATEGORY) && Objects.equals(TIME, boardBean.TIME) && Objects.equals(TITLE, boardBean.TITLE) && Objects.equals(CONTENT, boardBean.CONTENT) && Objects.equals(RECOMMEND, boardBean.RECOMMEND) && Objects.equals(ID, boardBean.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POSTNUM, CATEGORY, TIME, TITLE, CONTENT, RECOMMEND, ID);
    }

    @Override
    public String toString() {
        return "{" +
            " POSTNUM='" + getPOSTNUM() + "'" +
            ", CATEGORY='" + getCATEGORY() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", RECOMMEND='" + getRECOMMEND() + "'" +
            ", ID='" + getID() + "'" +
            "}";
    }

}