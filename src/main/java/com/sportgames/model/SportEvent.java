package com.sportgames.model;

import java.util.Set;

public class SportEvent {

    private long id;
    private String sport; // Вид спорта события
    private String timeEvent; //Время проведения события
    private Set<String> players; // Сет игроков, учавствующих в событии

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(String timeEvent) {
        this.timeEvent = timeEvent;
    }

    public Set<String> getPlayers() {
        return players;
    }

    public void setPlayers(Set<String> players) {
        this.players = players;
    }
}
