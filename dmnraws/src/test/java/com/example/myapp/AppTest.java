package com.example.myapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {
	@Test
	void testName() throws Exception {
		var stringName= "ABc";
		assertEquals("A",  String.valueOf(stringName.charAt(0)));
	}
}
