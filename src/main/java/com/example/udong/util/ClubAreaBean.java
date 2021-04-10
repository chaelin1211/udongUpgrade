package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLUB_AREA")
public class ClubAreaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer CLUB_NUM;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer AREA_NUM;

    public ClubAreaBean() {
    }

    public ClubAreaBean(Integer CLUB_NUM, Integer AREA_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        this.AREA_NUM = AREA_NUM;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public Integer getAREA_NUM() {
        return this.AREA_NUM;
    }

    public void setAREA_NUM(Integer AREA_NUM) {
        this.AREA_NUM = AREA_NUM;
    }

    public ClubAreaBean CLUB_NUM(Integer CLUB_NUM) {
        setCLUB_NUM(CLUB_NUM);
        return this;
    }

    public ClubAreaBean AREA_NUM(Integer AREA_NUM) {
        setAREA_NUM(AREA_NUM);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubAreaBean)) {
            return false;
        }
        ClubAreaBean clubAreaBean = (ClubAreaBean) o;
        return Objects.equals(CLUB_NUM, clubAreaBean.CLUB_NUM) && Objects.equals(AREA_NUM, clubAreaBean.AREA_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLUB_NUM, AREA_NUM);
    }

    @Override
    public String toString() {
        return "{" +
            " CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", AREA_NUM='" + getAREA_NUM() + "'" +
            "}";
    }

}