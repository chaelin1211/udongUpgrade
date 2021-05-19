package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLUB_MEMBER")
public class ClubMemberBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String USER_ID;
    Integer CLUB_NUM;

    public ClubMemberBean() {
    }

    public ClubMemberBean(String USER_ID, Integer CLUB_NUM) {
        this.USER_ID = USER_ID;
        this.CLUB_NUM = CLUB_NUM;
    }

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public ClubMemberBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
        return this;
    }

    public ClubMemberBean CLUB_NUM(Integer CLUB_NUM) {
        setCLUB_NUM(CLUB_NUM);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubMemberBean)) {
            return false;
        }
        ClubMemberBean clubMemberBean = (ClubMemberBean) o;
        return Objects.equals(USER_ID, clubMemberBean.USER_ID) && Objects.equals(CLUB_NUM, clubMemberBean.CLUB_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, CLUB_NUM);
    }

    @Override
    public String toString() {
        return "{" +
            " USER_ID='" + getUSER_ID() + "'" +
            ", CLUB_NUM='" + getCLUB_NUM() + "'" +
            "}";
    }

}