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
    Integer NUM;
    String TITLE;
    String CONTENT;


    public FaqBean() {
    }

    public FaqBean(Integer NUM, String TITLE, String CONTENT) {
        this.NUM = NUM;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
    }

    public Integer getNUM() {
        return this.NUM;
    }

    public void setNUM(Integer NUM) {
        this.NUM = NUM;
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

    public FaqBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public FaqBean TITLE(String TITLE) {
        this.TITLE = TITLE;
        return this;
    }

    public FaqBean CONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
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
        return Objects.equals(NUM, faqBean.NUM) && Objects.equals(TITLE, faqBean.TITLE) && Objects.equals(CONTENT, faqBean.CONTENT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUM, TITLE, CONTENT);
    }

    @Override
    public String toString() {
        return "{" +
            " NUM='" + getNUM() + "'" +
            ", TITLE='" + getTITLE() + "'" +
            ", CONTENT='" + getCONTENT() + "'" +
            "}";
    }

}