package com.zemoso.songApp.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemoso.songApp.entity.Song;



@RunWith(SpringRunner.class)
@SpringBootTest
class SongControllerTest {

	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Before
	private void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
//	@Test
//	void saveSongTest() throws JsonProcessingException {
//		
//		Song s1 = new Song(1,"Shape of You","Ed Sheeran");
//		
//		String jsonRequest = mapper.writeValueAsString(s1);
//		
//		MvcResult result = mockMvc.
//				perform(post("/songs/save").content(jsonRequest).content
//		
//	}

	
}
