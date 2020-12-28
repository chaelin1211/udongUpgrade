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
    Integer NUM;
    String NAME;


    public CategoryBean() {
    }

    public CategoryBean(Integer NUM, String NAME) {
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

    public CategoryBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public CategoryBean NAME(String NAME) {
        this.NAME = NAME;
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
        return Objects.equals(NUM, categoryBean.NUM) && Objects.equals(NAME, categoryBean.NAME);
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