package com.istvan.spring.demo.SpringDemo;

import com.istvan.spring.demo.SpringDemo.controller.TourController;
import com.istvan.spring.demo.SpringDemo.service.TourService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = TourController.class, secure = false)
public class SpringDemoApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MockMvcConfigurer configurer;

	@MockBean
	private TourService tourService;

	@Before
	public void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(configurer).build();
	}

	@Test
	public void getHistoryTours() {
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/v/1.0/tours?filter=HISTORY").accept(
//				MediaType.APPLICATION_JSON);
//		try {
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			assert result.getResponse().getContentLength() == 12;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
