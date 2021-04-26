package com.example.udong.util;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECOMMEND")
public class RecommendBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    Integer POST_NUM;
    String EMAIL;

    public RecommendBean() {
    }

    public RecommendBean(Integer POST_NUM, String EMAIL) {
        this.POST_NUM = POST_NUM;
        this.EMAIL = EMAIL;
    }

    public Integer getPOST_NUM() {
        return this.POST_NUM;
    }

    public void setPOST_NUM(Integer POST_NUM) {
        this.POST_NUM = POST_NUM;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public RecommendBean POST_NUM(Integer POST_NUM) {
        setPOST_NUM(POST_NUM);
        return this;
    }

    public RecommendBean EMAIL(String EMAIL) {
        setEMAIL(EMAIL);
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
        return Objects.equals(POST_NUM, recommendBean.POST_NUM) && Objects.equals(EMAIL, recommendBean.EMAIL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POST_NUM, EMAIL);
    }

    @Override
    public String toString() {
        return "{" +
            " POST_NUM='" + getPOST_NUM() + "'" +
            ", EMAIL='" + getEMAIL() + "'" +
            "}";
    }

}