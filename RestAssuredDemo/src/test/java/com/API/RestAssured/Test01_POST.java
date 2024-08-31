package com.API.RestAssured;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test01_POST {

//	@Test 
	public void test_1() {
		
//		 Map<String, Object> map = new HashMap<String, Object>();
//		 map.put("name", "Raghav");
//		 map.put("job", "Teacher");
		 
		 JSONObject request = new JSONObject();
		 request.put("name", "Kaifa");
		 request.put("Job", "Tester");

		 given()
		 	.header("Content-Type", "Applocation/JSON")
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(request.toJSONString())
		 .when()
		 	.post("https://reqres.in/api/users")
		 .then()
		 	.statusCode(201);
		  
	}
	
	@Test 
	public void test_2_PUT() {
		
//		 Map<String, Object> map = new HashMap<String, Object>();
//		 map.put("name", "Raghav");
//		 map.put("job", "Teacher");
		 
		 JSONObject request = new JSONObject();
		 request.put("name", "Kaifa");
		 request.put("Job", "Tester");

		 given()
		 	.header("Content-Type", "Applocation/JSON")
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(request.toJSONString())
		 .when()
		 	.put("https://reqres.in/api/users/2")
		 .then()
		 	.statusCode(200)
		 	.log().all();
		  
	}
	
//	@Test 
	public void test_2_PATCH() {
		
//		 Map<String, Object> map = new HashMap<String, Object>();
//		 map.put("name", "Raghav");
//		 map.put("job", "Teacher");
		 
		 JSONObject request = new JSONObject();
		 request.put("name", "Kaifa");
		 request.put("Job", "Tester");

		 given()
		 	.header("Content-Type", "Applocation/JSON")
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(request.toJSONString())
		 .when()
		 	.patch("https://reqres.in/api/users/2")
		 .then()
		 	.statusCode(201)
		 	.log().all();
		  
	}


}
 