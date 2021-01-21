package com.organicautonomy.rsvpservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organicautonomy.rsvpservice.dao.RsvpRepository;
import com.organicautonomy.rsvpservice.dto.Rsvp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RsvpController.class)
class RsvpControllerTest {
    private final Rsvp TO_SAVE = new Rsvp("Marco", 2);
    private final Rsvp RSVP = new Rsvp(1, "Marco", 2);
    private final Rsvp RSVP1 = new Rsvp(2, "Melly", 3);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RsvpRepository repository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllRsvps() throws Exception {
        List<Rsvp> rsvps = new ArrayList<>();
        rsvps.add(RSVP);
        rsvps.add(RSVP1);

        when(repository.findAll()).thenReturn(rsvps);

        String outputJson = mapper.writeValueAsString(rsvps);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/rsvp"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson))
                .andDo(print());
    }

    @Test
    void createRsvp() throws Exception {
        String inputJson = mapper.writeValueAsString(TO_SAVE);
        String outputJson = mapper.writeValueAsString(RSVP);

        when(repository.save(TO_SAVE)).thenReturn(RSVP);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/rsvp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson))
                .andDo(print());

    }
}