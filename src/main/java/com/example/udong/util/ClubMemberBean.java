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
    Integer NUM;
    Integer CLUB_NUM;
    String ID;


    public ClubMemberBean() {
    }

    public ClubMemberBean(Integer NUM, Integer CLUB_NUM, String ID) {
        this.NUM = NUM;
        this.CLUB_NUM = CLUB_NUM;
        this.ID = ID;
    }

    public Integer getNUM() {
        return this.NUM;
    }

    public void setNUM(Integer NUM) {
        this.NUM = NUM;
    }

    public Integer getCLUB_NUM() {
        return this.CLUB_NUM;
    }

    public void setCLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ClubMemberBean NUM(Integer NUM) {
        this.NUM = NUM;
        return this;
    }

    public ClubMemberBean CLUB_NUM(Integer CLUB_NUM) {
        this.CLUB_NUM = CLUB_NUM;
        return this;
    }

    public ClubMemberBean ID(String ID) {
        this.ID = ID;
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
        return Objects.equals(NUM, clubMemberBean.NUM) && Objects.equals(CLUB_NUM, clubMemberBean.CLUB_NUM) && Objects.equals(ID, clubMemberBean.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUM, CLUB_NUM, ID);
    }

    @Override
    public String toString() {
        return "{" +
            " NUM='" + getNUM() + "'" +
            ", CLUB_NUM='" + getCLUB_NUM() + "'" +
            ", ID='" + getID() + "'" +
            "}";
    }

}