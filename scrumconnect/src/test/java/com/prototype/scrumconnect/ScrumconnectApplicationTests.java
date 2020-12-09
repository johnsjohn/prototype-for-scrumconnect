package com.prototype.scrumconnect;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.scrumconnect.models.UserDataModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ScrumconnectApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testSaveMaleUser() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel("John", "male", 29, "India")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").exists()).andExpect(jsonPath("$.name").value("John"))
				.andExpect(jsonPath("$.age").exists()).andExpect(jsonPath("$.age").value(29))
				.andExpect(jsonPath("$.country").exists()).andExpect(jsonPath("$.country").value("India"))
				.andExpect(jsonPath("$.dateCreated").exists());
	}

	@Test
	public void testSaveFemaleUser() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel("John", "female", 29, "India")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").exists()).andExpect(jsonPath("$.name").value("John"))
				.andExpect(jsonPath("$.age").exists()).andExpect(jsonPath("$.age").value(29))
				.andExpect(jsonPath("$.country").exists()).andExpect(jsonPath("$.country").value("India"))
				.andExpect(jsonPath("$.dateCreated").exists());
	}

	@Test
	public void testSaveMissingName() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel(null, "female", 29, "India")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void testSaveMissingSex() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel("John", null, 29, "India")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void testSaveMissingAge() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel("John", "male", 0, "India")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void testSaveMissingCountry() throws Exception {
		mvc.perform(post("/userData").content(asJsonString(new UserDataModel("John", "male", 29, null)))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
