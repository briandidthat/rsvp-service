package com.organicautonomy.rsvpservice.dao;

import com.organicautonomy.rsvpservice.dto.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RsvpRepository extends JpaRepository<Rsvp, Integer> {
    List<Rsvp> findRsvpsByGuestName(String guestName);
    List<Rsvp> findRsvpsByGuestCount(Integer guestCount);
}
