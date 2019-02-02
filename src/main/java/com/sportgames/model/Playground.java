package com.sportgames.model;

import java.util.Set;

public class Playground {

    private long id;
    private String address; //type Address. Адрес площадки
    private Set<String> sports; // Виды спорта, поддерживаемые площадкой
    private Set<SportEvent> events; // Сет текущих ивентов площадки

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getSports() {
        return sports;
    }

    public void setSports(Set<String> sports) {
        this.sports = sports;
    }

    public Set<SportEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<SportEvent> events) {
        this.events = events;
    }

}
