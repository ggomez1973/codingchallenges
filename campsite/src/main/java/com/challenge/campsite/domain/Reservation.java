package com.challenge.campsite.domain;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

//@Entity
public class Reservation {
    private Long id;
    private UUID usercode;
    private Date fromDate;
    private Date toDate;
    private String name;
    private String email;

    public Reservation() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsercode(UUID usercode) {
        this.usercode = usercode;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public UUID getUsercode() {
        return usercode;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
