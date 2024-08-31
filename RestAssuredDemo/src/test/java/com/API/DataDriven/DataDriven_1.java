package com.API.DataDriven;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriven_1 extends DataProviders_Col {
	
	//@Test(dataProvider="DataForTest")
	public void test_post(String firstName, String lastName, int subjectId) {

		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

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
	
	@Test(dataProvider="DataForDel")
	public void test_delete(int userID) {
		
		baseURI = "http://localhost:3000/";
		
		when()
			.delete("/users/"+userID)
		.then()
			.statusCode(200)
			.log().all();
	}
}
