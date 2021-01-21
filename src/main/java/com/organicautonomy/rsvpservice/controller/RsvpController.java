package com.organicautonomy.rsvpservice.controller;

import com.organicautonomy.rsvpservice.dao.RsvpRepository;
import com.organicautonomy.rsvpservice.dto.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsvp")
public class RsvpController {
    @Autowired
    private RsvpRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rsvp> getAllRsvps() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        return repository.save(rsvp);
    }


}
