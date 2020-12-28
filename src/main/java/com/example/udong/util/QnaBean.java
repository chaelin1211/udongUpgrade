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
    Integer NUM;
    String TIME;
    String TITLE;
    String ID;
    String CONTENT;
    String EMAIL;


    public QnaBean() {
    }

    public QnaBean(Integer NUM, String TIME, String TITLE, String ID, String CONTENT, String EMAIL) {
        this.NUM = NUM;
        this.TIME = TIME;
        this.TITLE = TITLE;
        this.ID = ID;
        this.CONTENT = CONTENT;
        this.EMAIL = EMAIL;
    }

    public Integer getNUM() {
        return this.NUM;
    }

    public void setNUM(Integer NUM) {
        this.NUM = NUM;
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

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public QnaBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public QnaBean TIME(String TIME) {
        this.TIME = TIME;
        return this;
    }

    public QnaBean TITLE(String TITLE) {
        this.TITLE = TITLE;
        return this;
    }

    public QnaBean ID(String ID) {
        this.ID = ID;
        return this;
    }

    public QnaBean CONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
        return this;
    }

    public QnaBean EMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
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
        return Objects.equals(NUM, qnaBean.NUM) && Objects.equals(TIME, qnaBean.TIME) && Objects.equals(TITLE, qnaBean.TITLE) && Objects.equals(ID, qnaBean.ID) && Objects.equals(CONTENT, qnaBean.CONTENT) && Objects.equals(EMAIL, qnaBean.EMAIL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUM, TIME, TITLE, ID, CONTENT, EMAIL);
    }

    @Override
    public String toString() {
        return "{" +
            " NUM='" + getNUM() + "'" +
            ", TIME='" + getTIME() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", ID='" + getID() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            "}";
    }

}