package com.gamesys.timetravel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTravelControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TimeTravelController controller;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveTravelForCharacterWithNoTravel() throws Exception {
        mockMvc.perform(post("/api/v1/travels"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void saveTravelForCharacterWithEmptyTravel() throws Exception {
        TravelValueObject vo = new TravelValueObject();
        String requestJson = getJSONRequest(vo);
        mockMvc.perform(post("/api/v1/travels")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void saveTravelForCharacterWithInvalidPgi() throws Exception {
        TravelValueObject vo = new TravelValueObject("", "london", "2019-04-23T18:28:52.036Z");
        String requestJson = getJSONRequest(vo);
        mockMvc.perform(post("/api/v1/travels")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    private String getJSONRequest(TravelValueObject vo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(vo);
    }
}