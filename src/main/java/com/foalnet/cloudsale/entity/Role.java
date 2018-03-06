package com.foalnet.cloudsale.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dbo.t_role")
public class Role {
    @Id
    private Long id;
    private String name;
    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}