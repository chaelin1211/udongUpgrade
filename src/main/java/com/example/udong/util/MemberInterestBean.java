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
    Integer INTEREST_NUM;
    String USER_ID;

    public MemberInterestBean() {
    }

    public MemberInterestBean(Integer INTEREST_NUM, String USER_ID) {
        this.INTEREST_NUM = INTEREST_NUM;
        this.USER_ID = USER_ID;
    }

    public Integer getINTEREST_NUM() {
        return this.INTEREST_NUM;
    }

    public void setINTEREST_NUM(Integer INTEREST_NUM) {
        this.INTEREST_NUM = INTEREST_NUM;
    }

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public MemberInterestBean INTEREST_NUM(Integer INTEREST_NUM) {
        setINTEREST_NUM(INTEREST_NUM);
        return this;
    }

    public MemberInterestBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
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
        return Objects.equals(INTEREST_NUM, memberInterestBean.INTEREST_NUM) && Objects.equals(
                USER_ID, memberInterestBean.USER_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INTEREST_NUM, USER_ID);
    }

    @Override
    public String toString() {
        return "{" +
            " INTEREST_NUM='" + getINTEREST_NUM() + "'" +
            ", USER_ID='" + getUSER_ID() + "'" +
            "}";
    }
}