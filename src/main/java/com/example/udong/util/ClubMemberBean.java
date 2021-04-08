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
    String EMAIL;
    Integer CLUB_NUM;

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }


    @Override
    public String toString() {
        return "{" +
            " EMAIL='" + getEMAIL() + "'" +
            ", CLUB_NUM='" + getCLUB_NUM() + "'" +
            "}";
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClubMemberBean)) {
            return false;
        }
        ClubMemberBean clubMemberBean = (ClubMemberBean) o;
        return Objects.equals(EMAIL, clubMemberBean.EMAIL) && Objects.equals(CLUB_NUM, clubMemberBean.CLUB_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EMAIL, CLUB_NUM);
    }


    public ClubMemberBean() {
    }

    public ClubMemberBean(Integer CLUB_NUM, String EMAIL) {
        this.EMAIL = EMAIL;
        this.CLUB_NUM = CLUB_NUM;
    }
    public ClubMemberBean CLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        return this;
    }

    public ClubMemberBean EMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
        return this;
    }



}