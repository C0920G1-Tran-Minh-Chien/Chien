package com.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String cost;
    private int unit;
    private String status;

    @OneToMany(mappedBy = "attachService")

    public AttachService() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
