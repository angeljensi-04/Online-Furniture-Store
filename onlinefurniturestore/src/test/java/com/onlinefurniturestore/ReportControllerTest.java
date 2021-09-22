package com.onlinefurniturestore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.controller.ReportController;

@SpringBootTest
class ReportControllerTest {

	@Autowired
	private ReportController controller;

	@Test
	 void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
