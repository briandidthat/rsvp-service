package com.organicautonomy.rsvpservice.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RsvpTest {
    private Rsvp rsvp;

    @BeforeEach
    void setUp() {
        rsvp = new Rsvp(1,"Marco", 29);
    }

    @Test
    void getId() {
        assertEquals(1, rsvp.getId());
    }

    @Test
    void getGuestName() {
        assertEquals("Marco", rsvp.getGuestName());
    }

    @Test
    void getGuestCount() {
        assertEquals(29, rsvp.getGuestCount());
    }
}