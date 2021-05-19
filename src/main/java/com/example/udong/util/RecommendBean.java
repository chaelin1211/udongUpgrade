package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECOMMEND")
public class RecommendBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    Integer POST_NUM;
    String USER_ID;

    public RecommendBean() {
    }

    public RecommendBean(Integer POST_NUM, String USER_ID) {
        this.POST_NUM = POST_NUM;
        this.USER_ID = USER_ID;
    }

    public Integer getPOST_NUM() {
        return this.POST_NUM;
    }

    public void setPOST_NUM(Integer POST_NUM) {
        this.POST_NUM = POST_NUM;
    }

    public String getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public RecommendBean POST_NUM(Integer POST_NUM) {
        setPOST_NUM(POST_NUM);
        return this;
    }

    public RecommendBean USER_ID(String USER_ID) {
        setUSER_ID(USER_ID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecommendBean)) {
            return false;
        }
        RecommendBean recommendBean = (RecommendBean) o;
        return Objects.equals(POST_NUM, recommendBean.POST_NUM) && Objects.equals(USER_ID, recommendBean.USER_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POST_NUM, USER_ID);
    }

    @Override
    public String toString() {
        return "{" +
            " POST_NUM='" + getPOST_NUM() + "'" +
            ", USER_ID='" + getUSER_ID() + "'" +
            "}";
    }

}