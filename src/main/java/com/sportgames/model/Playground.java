package com.sportgames.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playgrounds")
public class Playground {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "address", unique = true, nullable = false)
    private String address; //type Address. Адрес площадки

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Sport> sports; // Виды спорта, поддерживаемые площадкой



    public Playground(){}

    public Playground(String address){
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

}
