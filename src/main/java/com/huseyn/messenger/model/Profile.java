package com.huseyn.messenger.model;

import java.util.Date;

public class Profile {
    
    private int id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;

    public Profile() {
    }

    public Profile(int id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }

    public int getId() {
        return id;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    
    
}
