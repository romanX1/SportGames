package com.sportgames.model;

import javax.persistence.*;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(nullable=false)
    private final Long maxDuration;

    public Sport() {
        this.maxDuration=1000*60*60L;
    }

    public Sport(String type, Long maxDuration) {
        this.type = type;
        this.maxDuration=maxDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
