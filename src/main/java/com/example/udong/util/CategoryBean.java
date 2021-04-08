package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class CategoryBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    Integer CATEGORY_NUM;
    String CATEGORY_NAME;


    public CategoryBean() {
    }

    public CategoryBean(Integer CATEGORY_NUM, String CATEGORY_NAME) {
        this.CATEGORY_NUM = CATEGORY_NUM;
        this.CATEGORY_NAME = CATEGORY_NAME;
    }

    public Integer getCATEGORY_NUM() {
        return this.CATEGORY_NUM;
    }

    public void setCATEGORY_NUM(Integer CATEGORY_NUM) {
        this.CATEGORY_NUM = CATEGORY_NUM;
    }

    public String getCATEGORY_NAME() {
        return this.CATEGORY_NAME;
    }

    public void setCATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;
    }

    public CategoryBean CATEGORY_NUM(Integer CATEGORY_NUM) {
        this.CATEGORY_NUM = CATEGORY_NUM;
        return this;
    }

    public CategoryBean CATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CategoryBean)) {
            return false;
        }
        CategoryBean categoryBean = (CategoryBean) o;
        return Objects.equals(CATEGORY_NAME, categoryBean.CATEGORY_NAME) && Objects.equals(CATEGORY_NUM, categoryBean.CATEGORY_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CATEGORY_NUM, CATEGORY_NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " CATEGORY_NUM='" + getCATEGORY_NUM() + "'" +
            ", CATEGORY_NAME='" + getCATEGORY_NAME() + "'" +
            "}";
    }

}