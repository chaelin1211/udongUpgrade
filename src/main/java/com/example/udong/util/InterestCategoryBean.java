package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INTEREST_CATEGORY")
public class InterestCategoryBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    Integer NUM;
    String NAME;


    public InterestCategoryBean() {
    }

    public InterestCategoryBean(Integer NUM, String NAME) {
        this.NUM = NUM;
        this.NAME = NAME;
    }

    public Integer getNUM() {
        return this.NUM;
    }

    public void setNUM(Integer NUM) {
        this.NUM = NUM;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public InterestCategoryBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public InterestCategoryBean NAME(String NAME) {
        this.NAME = NAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof InterestCategoryBean)) {
            return false;
        }
        InterestCategoryBean interestCategoryBean = (InterestCategoryBean) o;
        return Objects.equals(NUM, interestCategoryBean.NUM) && Objects.equals(NAME, interestCategoryBean.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUM, NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " NUM='" + getNUM() + "'" +
            ", NAME='" + getNAME() + "'" +
            "}";
    }

}