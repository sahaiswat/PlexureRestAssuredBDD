package com.qa.rest.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import org.testng.annotations.Test;




public class LoginTests {
	
	 String postrequest= "{\"username\": \"Tester\",\"password\": \"Plexure123\"}";
	 String postrequest1= "{\"username\": \"\",\"password\": \"\"}";
	 String postrequest2= "{\"username\": \"Tester\",\"password\": \"Plexure1234\"}";
	 String postrequest3= "{\"username\": \"Tester1\",\"password\": \"Plexure123\"}";
   
	   @Test
		public void testPost()
		{
		given()
		
		.contentType("application/json")
		.body(postrequest)
		
		.when()
		.post("https://qatestapi.azurewebsites.net/api/login")
		
		.then()
		.statusCode(200)
		.and()
		.body("UserId",equalTo (1))
		.and()
		.body("UserName", equalTo ("Tester"))
		.and()
		.body("AccessToken", equalTo ("37cb9e58-99db-423c-9da5-42d5627614c5"))
		.log().all();
		}
		
	 
	@Test
	public void testPostnousernameandpassword()
	{
	given()
	
	.contentType("application/json")
	.body(postrequest1)
	.when()
	.post("https://qatestapi.azurewebsites.net/api/login")
	
	.then()
	.statusCode(400)
	.and()
	
	.log().all();
	}

	@Test
	public void testPostInvalidPassword()
	{
	given()
	
	.contentType("application/json")
	.body(postrequest2)
	.when()
	.post("https://qatestapi.azurewebsites.net/api/login")
	
	.then()
	.statusCode(401)
	.and()
	
	.log().all();
	}
	
	@Test
	public void testPostInvalidUsername()
	{
	given()
	
	.contentType("application/json")
	.body(postrequest3)
	.when()
	.post("https://qatestapi.azurewebsites.net/api/login")
	
	.then()
	.statusCode(401)
	.and()
	
	.log().all();
	}
}
