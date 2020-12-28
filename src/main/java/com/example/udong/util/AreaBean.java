package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AREA")
public class AreaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    String AREA_NUM;
    String AREA_NAME;


    public AreaBean() {
    }

    public AreaBean(String AREA_NUM, String AREA_NAME) {
        this.AREA_NUM = AREA_NUM;
        this.AREA_NAME = AREA_NAME;
    }

    public String getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(String AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public String getAREA_NAME() {
        return this.AREA_NAME;
    }

    public void setAREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
    }

    public AreaBean AREA_NUM(String AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
        return this;
    }

    public AreaBean AREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AreaBean)) {
            return false;
        }
        AreaBean areaBean = (AreaBean) o;
        return Objects.equals(AREA_NUM, areaBean.AREA_NUM) && Objects.equals(AREA_NAME, areaBean.AREA_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AREA_NUM, AREA_NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " AREA_NUM='" + getAREA_NUM() + "'" +
            ", AREA_NAME='" + getAREA_NAME() + "'" +
            "}";
    }

}