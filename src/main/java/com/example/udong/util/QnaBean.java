package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QNA")
public class QnaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer QNA_NUM;
    String TIME;
    String TITLE;
    String NICKNAME;
    String CONTENT;
    String EMAIL;

    public QnaBean() {
    }

    public QnaBean(Integer QNA_NUM, String TIME, String TITLE, String NICKNAME, String CONTENT, String EMAIL) {
        this.QNA_NUM = QNA_NUM;
        this.TIME = TIME;
        this.TITLE = TITLE;
        this.NICKNAME = NICKNAME;
        this.CONTENT = CONTENT;
        this.EMAIL = EMAIL;
    }

    public Integer getQNA_NUM() {
        return this.QNA_NUM;
    }

    public void setQNA_NUM(Integer QNA_NUM) {
        this.QNA_NUM = QNA_NUM;
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

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public QnaBean QNA_NUM(Integer QNA_NUM) {
        setQNA_NUM(QNA_NUM);
        return this;
    }

    public QnaBean TIME(String TIME) {
        setTIME(TIME);
        return this;
    }

    public QnaBean TITLE(String TITLE) {
        setTITLE(TITLE);
        return this;
    }

    public QnaBean NICKNAME(String NICKNAME) {
        setNICKNAME(NICKNAME);
        return this;
    }

    public QnaBean CONTENT(String CONTENT) {
        setCONTENT(CONTENT);
        return this;
    }

    public QnaBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QnaBean)) {
            return false;
        }
        QnaBean qnaBean = (QnaBean) o;
        return Objects.equals(QNA_NUM, qnaBean.QNA_NUM) && Objects.equals(TIME, qnaBean.TIME) && Objects.equals(TITLE, qnaBean.TITLE) && Objects.equals(NICKNAME, qnaBean.NICKNAME) && Objects.equals(CONTENT, qnaBean.CONTENT) && Objects.equals(EMAIL, qnaBean.EMAIL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(QNA_NUM, TIME, TITLE, NICKNAME, CONTENT, EMAIL);
    }

    @Override
    public String toString() {
        return "{" +
            " QNA_NUM='" + getQNA_NUM() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", NICKNAME='" + getNICKNAME() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            "}";
    }


}