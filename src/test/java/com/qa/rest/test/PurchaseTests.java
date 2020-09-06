package com.qa.rest.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PurchaseTests {
	
	 String postrequest1= "{\"product_id\": \"1\"}";
	 String postrequest2= "{\"product_id\": \"abc\"}";
	 
	 @Test
		public void testSuccessfulPoints()
		{
		given()
		.header("token","37cb9e58-99db-423c-9da5-42d5627614c5")
		.contentType("application/json")
		
		.body(postrequest1)
		
		.when()
		.post("https://qatestapi.azurewebsites.net/api/purchase")
			
		.then()
		.statusCode(202)
		.and()
		.log().all();
		}
	 
	 @Test
		public void testUnsuccessfulPoints()
		{
		given()
		.header("token","37cb9e58-99db-423c-9da5-42d5627614c5")
		.contentType("application/json")
		
		.body(postrequest2)
		
		.when()
		.post("https://qatestapi.azurewebsites.net/api/purchase")
			
		.then()
		.statusCode(400)
		.and()
					
		.log().all();
		}

}
