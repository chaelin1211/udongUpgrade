package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAQ")
public class FaqBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer FAQ_NUM;
    String TITLE;
    String CONTENT;
    String USER_ID;

    public FaqBean() {
    }

    public FaqBean(Integer FAQ_NUM, String TITLE, String CONTENT, String USER_ID) {
        this.FAQ_NUM = FAQ_NUM;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.USER_ID = USER_ID;
    }

    public Integer getFAQ_NUM() {
        return this.FAQ_NUM;
    }

    public void setFAQ_NUM(Integer FAQ_NUM) {
        this.FAQ_NUM = FAQ_NUM;
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

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public FaqBean FAQ_NUM(Integer FAQ_NUM) {
        setFAQ_NUM(FAQ_NUM);
        return this;
    }

    public FaqBean TITLE(String TITLE) {
        setTITLE(TITLE);
        return this;
    }

    public FaqBean CONTENT(String CONTENT) {
        setCONTENT(CONTENT);
        return this;
    }

    public FaqBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FaqBean)) {
            return false;
        }
        FaqBean faqBean = (FaqBean) o;
        return Objects.equals(FAQ_NUM, faqBean.FAQ_NUM) && Objects.equals(TITLE, faqBean.TITLE) && Objects.equals(CONTENT, faqBean.CONTENT) && Objects.equals(USER_ID, faqBean.USER_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FAQ_NUM, TITLE, CONTENT, USER_ID);
    }

    @Override
    public String toString() {
        return "{" +
            " FAQ_NUM='" + getFAQ_NUM() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            ", USER_ID='" + getUSER_ID() + "'" +
            "}";
    }

}