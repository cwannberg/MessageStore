package com.example.demo;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TextMessagesTest extends TestClass {

	//Test to verify that our application has deployed correctly and making sure
	// that the success - 200 HTTP result is returned
	@Test
	public void basicPingTest() {
		given().when().get("/textmessages").then().statusCode(200);
	}



}