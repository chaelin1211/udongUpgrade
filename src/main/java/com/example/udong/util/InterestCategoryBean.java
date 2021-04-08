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
    Integer INTEREST_NUM;
    String INTEREST_NAME;

    public InterestCategoryBean() {
    }

    public InterestCategoryBean(Integer INTEREST_NUM, String INTEREST_NAME) {
        this.INTEREST_NUM = INTEREST_NUM;
        this.INTEREST_NAME = INTEREST_NAME;
    }

    public Integer getINTEREST_NUM() {
        return this.INTEREST_NUM;
    }

    public void setINTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public String getINTEREST_NAME() {
        return this.INTEREST_NAME;
    }

    public void setINTEREST_NAME(String INTEREST_NAME) {
        this.INTEREST_NAME = INTEREST_NAME;
    }

    public InterestCategoryBean INTEREST_NUM(Integer INTEREST_NUM) {
        setINTEREST_NUM(INTEREST_NUM);
        return this;
    }

    public InterestCategoryBean INTEREST_NAME(String INTEREST_NAME) {
        setINTEREST_NAME(INTEREST_NAME);
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
        return Objects.equals(INTEREST_NUM, interestCategoryBean.INTEREST_NUM) && Objects.equals(INTEREST_NAME, interestCategoryBean.INTEREST_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INTEREST_NUM, INTEREST_NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " INTEREST_NUM='" + getINTEREST_NUM() + "'" +
            ", INTEREST_NAME='" + getINTEREST_NAME() + "'" +
            "}";
    }
}