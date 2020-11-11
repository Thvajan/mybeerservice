package me.learning.mybeerservice;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.learning.mybeerservice.web.controller.BeerController;
import me.learning.mybeerservice.web.model.BeerDTO;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getBeerById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void saveNewBeer() throws Exception {

		BeerDTO beerDTO = BeerDTO.builder().build();
		String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON)
				.content(beerDTOJson)).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void updateBeer() throws Exception {

		BeerDTO beerDTO = BeerDTO.builder().build();
		String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON).content(beerDTOJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
