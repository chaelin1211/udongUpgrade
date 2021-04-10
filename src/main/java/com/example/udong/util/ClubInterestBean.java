package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLUB_INTEREST")
public class ClubInterestBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer CLUB_NUM;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer INTEREST_NUM;

    public ClubInterestBean() {
    }

    public ClubInterestBean(Integer CLUB_NUM, Integer INTEREST_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public Integer getINTEREST_NUM() {
        return this.INTEREST_NUM;
    }

    public void setINTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public ClubInterestBean CLUB_NUM(Integer CLUB_NUM) {
        setCLUB_NUM(CLUB_NUM);
        return this;
    }

    public ClubInterestBean INTEREST_NUM(Integer INTEREST_NUM) {
        setINTEREST_NUM(INTEREST_NUM);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubInterestBean)) {
            return false;
        }
        ClubInterestBean clubInterestBean = (ClubInterestBean) o;
        return Objects.equals(CLUB_NUM, clubInterestBean.CLUB_NUM) && Objects.equals(INTEREST_NUM, clubInterestBean.INTEREST_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLUB_NUM, INTEREST_NUM);
    }

    @Override
    public String toString() {
        return "{" +
            " CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", INTEREST_NUM='" + getINTEREST_NUM() + "'" +
            "}";
    }
}
