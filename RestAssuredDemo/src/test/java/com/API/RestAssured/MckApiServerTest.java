package com.API.RestAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class MckApiServerTest {
	
	//@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.param("name", "Automation")
			.get("/subjects")
		.then()
			.statusCode(200)
			.log().all();
	}

	//@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Madara");
		request.put("lastName", "Uchiha");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "Application/json")
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	//@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Itachi");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "Application/json")
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	//@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Hashirama");
		request.put("lastName", "Senju");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "Application/json")
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when()
			.delete("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}
}