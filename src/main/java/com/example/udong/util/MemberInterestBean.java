package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER_INTEREST")
public class MemberInterestBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer NUM;
    String ID;
    String NAME;


    public MemberInterestBean() {
    }

    public MemberInterestBean(Integer NUM, String ID, String NAME) {
        this.NUM = NUM;
        this.ID = ID;
        this.NAME = NAME;
    }

    public Integer getNUM() {
        return this.NUM;
    }

    public void setNUM(Integer NUM) {
        this.NUM = NUM;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public MemberInterestBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public MemberInterestBean ID(String ID) {
        this.ID = ID;
        return this;
    }

    public MemberInterestBean NAME(String NAME) {
        this.NAME = NAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MemberInterestBean)) {
            return false;
        }
        MemberInterestBean memberInterestBean = (MemberInterestBean) o;
        return Objects.equals(NUM, memberInterestBean.NUM) && Objects.equals(ID, memberInterestBean.ID) && Objects.equals(NAME, memberInterestBean.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUM, ID, NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " NUM='" + getNUM() + "'" +
            ", ID='" + getID() + "'" +
            ", NAME='" + getNAME() + "'" +
            "}";
    }


}