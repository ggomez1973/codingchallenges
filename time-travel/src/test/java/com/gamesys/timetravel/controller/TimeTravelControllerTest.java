package com.gamesys.timetravel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeTravelControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private TimeTravelController controller;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void saveTravelForCharacter_WithInvalidPgi() throws Exception {
        TravelValueObject vo = new TravelValueObject("london", LocalDateTime.now());
        String requestJson = convertJSONBodyToString(vo);
        String errorMessage = mockMvc.perform(post(TimeTravelController.BASE_URL+"/{pgi}/travels", "2Invalid")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
        Assert.assertEquals("Invalid Personal Galactic Identifier", errorMessage);
    }

    @Test
    public void saveTravelForCharacter_WithInvalidPlace() throws Exception {
        TravelValueObject vo = new TravelValueObject("", LocalDateTime.now());
        String requestJson = convertJSONBodyToString(vo);
        String errorMessage = mockMvc.perform(post(TimeTravelController.BASE_URL+"/{pgi}/travels", "aValidPgi")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
        Assert.assertEquals("No such place", errorMessage);
    }

    @Test
    public void saveTravelForCharacter_WithNullPlace() throws Exception {
        TravelValueObject vo = new TravelValueObject(null, LocalDateTime.now());
        String requestJson = convertJSONBodyToString(vo);
        String errorMessage = mockMvc.perform(post(TimeTravelController.BASE_URL+"/{pgi}/travels", "aValidPgi")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
        Assert.assertEquals("place should not be null", errorMessage);
    }

    @Test
    public void saveTravelForCharacter_WithNullDate() throws Exception {
        TravelValueObject vo = new TravelValueObject("london", null);
        String requestJson = convertJSONBodyToString(vo);
        String errorMessage = mockMvc.perform(post(TimeTravelController.BASE_URL+"/aValidPgi/travels")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
        Assert.assertEquals("date should not be null", errorMessage);
    }

    /**
     * Conversion Utility
     * @param vo A Travel value object
     * @return  A String representation fromValueObject the JSON object
     * @throws JsonProcessingException
     */
    private String convertJSONBodyToString(TravelValueObject vo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(vo);
    }
}