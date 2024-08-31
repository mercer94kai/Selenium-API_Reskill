package test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class testsOnLocalApi {
	
//	@Test
	public void GET() {
		
		baseURI="http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().all();
		
	}
	
//	@Test
	public void POST() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Isagi");
		request.put("lastName", "Yoichi");
		request.put("subjectId", 2);
		
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
//	@Test
	public void PUT() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Kenpachi");
		request.put("lastName", "Zaraki");
		
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/9").
		then().
			statusCode(200).
			log().all();
		
	}
	
//	@Test
	public void PATCH() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Izanagi");
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/8").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void DELETE() {
		
		baseURI="http://localhost:3000";
		
		when()
			.delete("/users/8")
		.then() 
			.statusCode(200)
			.log().all();
		
	}
}
