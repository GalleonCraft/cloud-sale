package com.foalnet.cloudsale.entity;

import javax.persistence.*;

@Table(name = "dbo.aaaa")
public class BaseEntity {
    @Id
    private Integer id;
    private Integer fbomid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFbomid() {
        return fbomid;
    }

    public void setFbomid(Integer fbomid) {
        this.fbomid = fbomid;
    }
}
