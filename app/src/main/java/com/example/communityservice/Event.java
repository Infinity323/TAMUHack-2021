package com.example.communityservice;

public class Event {
    private String name;
    private String org;

    public Event(String name, String org) {
        this.name = name;
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
