package com.sportgames.model;

import javax.persistence.*;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "type", nullable = false)
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
