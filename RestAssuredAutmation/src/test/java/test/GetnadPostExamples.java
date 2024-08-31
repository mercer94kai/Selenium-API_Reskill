package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetnadPostExamples {
	
//	@Test
	public void testGET() {
		
		baseURI="https://reqres.in/api";
		
		given()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("data.first_name[4]",equalTo("George"))
			.body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
	@Test
	public void testPOST() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Kaifa");
//		map.put("Job", "Tester");
//		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Kaifa");
		request.put("Job", "Tester");
		System.out.println(request.toJSONString()); 
		
		baseURI="https://reqres.in/api";
		
		given()
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then() 
			.statusCode(201)
			.log().all();
		
		
	}

}
