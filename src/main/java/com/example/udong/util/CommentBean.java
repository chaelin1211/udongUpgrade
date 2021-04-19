package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class CommentBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer CO_NUM;
    Integer POST_NUM;
    String EMAIL;
    String NICKNAME;
    String CONTENT;
    String TIME;

    public CommentBean() {
    }

    public CommentBean(Integer CO_NUM, Integer POST_NUM, String EMAIL, String NICKNAME, String CONTENT, String TIME) {
        this.CO_NUM = CO_NUM;
        this.POST_NUM = POST_NUM;
        this.EMAIL = EMAIL;
        this.NICKNAME = NICKNAME;
        this.CONTENT = CONTENT;
        this.TIME = TIME;
    }

    public Integer getCO_NUM() {
        return this.CO_NUM;
    }

    public void setCO_NUM(Integer CO_NUM) {
        this.CO_NUM = CO_NUM;
    }

    public Integer getPOST_NUM() {
        return this.POST_NUM;
    }

    public void setPOST_NUM(Integer POST_NUM) {
        this.POST_NUM = POST_NUM;
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

    public String getCONTENT() {
        return this.CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getTIME() {
        return this.TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public CommentBean CO_NUM(Integer CO_NUM) {
        setCO_NUM(CO_NUM);
        return this;
    }

    public CommentBean POST_NUM(Integer POST_NUM) {
        setPOST_NUM(POST_NUM);
        return this;
    }

    public CommentBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
        return this;
    }

    public CommentBean NICKNAME(String NICKNAME) {
        setNICKNAME(NICKNAME);
        return this;
    }

    public CommentBean CONTENT(String CONTENT) {
        setCONTENT(CONTENT);
        return this;
    }

    public CommentBean TIME(String TIME) {
        setTIME(TIME);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentBean)) {
            return false;
        }
        CommentBean commentBean = (CommentBean) o;
        return Objects.equals(CO_NUM, commentBean.CO_NUM) && Objects.equals(POST_NUM, commentBean.POST_NUM) && Objects.equals(EMAIL, commentBean.EMAIL) && Objects.equals(NICKNAME, commentBean.NICKNAME) && Objects.equals(CONTENT, commentBean.CONTENT) && Objects.equals(TIME, commentBean.TIME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CO_NUM, POST_NUM, EMAIL, NICKNAME, CONTENT, TIME);
    }

    @Override
    public String toString() {
        return "{" +
            " CO_NUM='" + getCO_NUM() + "'" +
            ", POST_NUM='" + getPOST_NUM() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", TIME='" + getTIME() + "'" +
            "}";
    }

}