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
    Integer POST_NUM;
    Integer CATEGORY_NUM;
    String TIME;
    String TITLE;
    String CONTENT;
    String EMAIL;
    String NICKNAME;

    public BoardBean() {
    }

    public BoardBean(Integer POST_NUM, Integer CATEGORY_NUM, String TIME, String TITLE, String CONTENT, String EMAIL, String NICKNAME) {
        this.POST_NUM = POST_NUM;
        this.CATEGORY_NUM = CATEGORY_NUM;
        this.TIME = TIME;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.EMAIL = EMAIL;
        this.NICKNAME = NICKNAME;
    }

    public Integer getPOST_NUM() {
        return this.POST_NUM;
    }

    public void setPOST_NUM(Integer POST_NUM) {
        this.POST_NUM = POST_NUM;
    }

    public Integer getCATEGORY_NUM() {
        return this.CATEGORY_NUM;
    }

    public void setCATEGORY_NUM(Integer CATEGORY_NUM) {
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

    public BoardBean POST_NUM(Integer POST_NUM) {
        setPOST_NUM(POST_NUM);
        return this;
    }

    public BoardBean CATEGORY_NUM(Integer CATEGORY_NUM) {
        setCATEGORY_NUM(CATEGORY_NUM);
        return this;
    }

    public BoardBean TIME(String TIME) {
        setTIME(TIME);
        return this;
    }

    public BoardBean TITLE(String TITLE) {
        setTITLE(TITLE);
        return this;
    }

    public BoardBean CONTENT(String CONTENT) {
        setCONTENT(CONTENT);
        return this;
    }

    public BoardBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
        return this;
    }

    public BoardBean NICKNAME(String NICKNAME) {
        setNICKNAME(NICKNAME);
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
        return Objects.equals(POST_NUM, boardBean.POST_NUM) && Objects.equals(CATEGORY_NUM, boardBean.CATEGORY_NUM) && Objects.equals(TIME, boardBean.TIME) && Objects.equals(TITLE, boardBean.TITLE) && Objects.equals(CONTENT, boardBean.CONTENT) && Objects.equals(EMAIL, boardBean.EMAIL) && Objects.equals(NICKNAME, boardBean.NICKNAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POST_NUM, CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL, NICKNAME);
    }

    @Override
    public String toString() {
        return "{" +
            " POST_NUM='" + getPOST_NUM() + "'" +
            ", CATEGORY_NUM='" + getCATEGORY_NUM() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            "}";
    }

}