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
    String POST_NUM;
    String ID;


    public RecommendBean() {
    }

    public RecommendBean(String POST_NUM, String ID) {
        this.POST_NUM = POST_NUM;
        this.ID = ID;
    }

    public String getPOST_NUM() {
        return this.POST_NUM;
    }

    public void setPOST_NUM(String POST_NUM) {
        this.POST_NUM = POST_NUM;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public RecommendBean POST_NUM(String POST_NUM) {
        this.POST_NUM = POST_NUM;
        return this;
    }

    public RecommendBean ID(String ID) {
        this.ID = ID;
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
        return Objects.equals(POST_NUM, recommendBean.POST_NUM) && Objects.equals(ID, recommendBean.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(POST_NUM, ID);
    }

    @Override
    public String toString() {
        return "{" +
            " POST_NUM='" + getPOST_NUM() + "'" +
            ", ID='" + getID() + "'" +
            "}";
    }
    

}