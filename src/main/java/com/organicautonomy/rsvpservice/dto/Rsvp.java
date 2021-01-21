package com.organicautonomy.rsvpservice.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rsvp")
public class Rsvp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String guestName;
    private Integer guestCount;

    public Rsvp() {
    }

    public Rsvp(String guestName, Integer guestCount) {
        this.guestName = guestName;
        this.guestCount = guestCount;
    }

    public Rsvp(Integer id, String guestName, Integer guestCount) {
        this.id = id;
        this.guestName = guestName;
        this.guestCount = guestCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return Objects.equals(id, rsvp.id) && Objects.equals(guestName, rsvp.guestName) && Objects.equals(guestCount, rsvp.guestCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestName, guestCount);
    }
}
