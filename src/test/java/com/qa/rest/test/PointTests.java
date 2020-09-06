package com.qa.rest.test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PointTests {
	
	
	 String postrequest1= "{\"product_id\": \"1\"}";
	 String postrequest2= "{\"product_id\": \"1\"}";
	 
	 @Test
		public void testSuccessfulPoints()
		{
		given()
		.header("token","37cb9e58-99db-423c-9da5-42d5627614c5")
		.contentType("application/json")
		
		.body(postrequest1)
		
		.when()
		.get("https://qatestapi.azurewebsites.net/api/points")
			
		.then()
		.statusCode(202)
		.and()
		.body("UserId",equalTo (1))
		.and()
		.body("Points", equalTo (346400))
		
		.log().all();
		}
	 
	 @Test
		public void testUnsuccessfulPoints()
		{
		given()
		.header("token","37cb9e5-99db-423c-9da5-42d5627614c5")
		.contentType("application/json")
		
		.body(postrequest2)
		
		.when()
		.get("https://qatestapi.azurewebsites.net/api/points")
			
		.then()
		.statusCode(401)
		.and()
		.log().all();
		}

}
