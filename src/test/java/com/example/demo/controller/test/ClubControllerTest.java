package com.example.demo.controller.test;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.entities.Club;
import com.example.demo.repository.ClubRepository;

@SpringBootTest
@AutoConfigureMockMvc
class ClubControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ClubRepository clubRepository;

	@BeforeEach
	void setup() {
		clubRepository.deleteAll();
	}

	@Test
	void testCreateAndGetClub() throws Exception {
		mockMvc
		        .perform(post("/clubs").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Chess Club\"}"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.name").value("Chess Club"));

		// Retrieve
		mockMvc
		        .perform(get("/clubs"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", hasSize(1)))
		        .andExpect(jsonPath("$[0].name").value("Chess Club"));
	}

	@Test
	void testUpdateClub() throws Exception {
		Club club = new Club();
		club.setName("Drama Club");
		Club saved = clubRepository.save(club);

		saved.setName("Theater Club");

		mockMvc
		        .perform(put("/clubs/" + saved.getId()).contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Theater Club\"}"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.name").value("Theater Club"));
	}

	@Test
	void testDeleteClub() throws Exception {
		Club club = new Club();
		club.setName("Science Club");
		Club saved = clubRepository.save(club);

		mockMvc.perform(delete("/clubs/" + saved.getId())).andExpect(status().isNoContent());

		mockMvc.perform(get("/clubs/" + saved.getId())).andExpect(status().isNotFound());
	}

	@Test
	void testSearchByName() throws Exception {
		Club club = new Club();
		club.setName("Music Club");
		club.setMembers(Collections.emptySet());
		clubRepository.save(club);

		mockMvc
		        .perform(get("/clubs/search").param("name", "music"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", hasSize(1)))
		        .andExpect(jsonPath("$[0].name").value("Music Club"));
	}
}
