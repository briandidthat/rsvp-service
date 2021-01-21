package com.organicautonomy.rsvpservice.dao;

import com.organicautonomy.rsvpservice.dto.Rsvp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RsvpRepositoryTest {
    @Autowired
    private RsvpRepository repository;
    private Rsvp rsvp, rsvp1;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        rsvp = new Rsvp("Marco", 29);
        rsvp1 = new Rsvp("Melly", 2);
    }

    @Test
    void saveFindRsvp() {
        rsvp = repository.save(rsvp);
        Optional<Rsvp> fromRepository = repository.findById(rsvp.getId());

        assertEquals(fromRepository.get(), rsvp);
    }

    @Test
    void findRsvpsByGuestName() {
        rsvp1 = repository.save(rsvp1);

        List<Rsvp> rsvps = repository.findRsvpsByGuestName(rsvp1.getGuestName());

        assertEquals(1, rsvps.size());
    }

    @Test
    void findRsvpsByGuestCount() {
        rsvp = repository.save(rsvp);

        List<Rsvp> rsvps = repository.findRsvpsByGuestCount(rsvp.getGuestCount());

        assertEquals(1, rsvps.size());
    }
}