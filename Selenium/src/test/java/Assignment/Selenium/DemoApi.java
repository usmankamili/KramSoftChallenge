package Assignment.Selenium;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import POJO.JsonObject;
import io.restassured.RestAssured;

public class DemoApi {
	
	@Test
	public void getRequest()
	{
		RestAssured.baseURI ="https://api.agify.io";
		JsonObject response = given().queryParam("name", "bella")
		.header("Content-Type","application/json")
		.when()
		.get()
		.then()
		.assertThat().statusCode(200)
		.extract().body().as(JsonObject.class);
		assertEquals(response.getAge() , 35 , "incorrect age");
		assertEquals(response.getName() , "bella" , "incorrect name");
		assertEquals(response.getCount() , 40138 , "incorrect count");	
		
	}
	

}
