package api.endpoints;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response resp =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return resp;
		
	}
	
	public static Response readUser(String userName)
	{
		Response resp =given()
			.pathParam("username",userName)
		
		.when()
			.post(Routes.get_url);
		
		return resp;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		Response resp =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName)
			.body(payload)
		
		.when()
			.post(Routes.update_url);
		
		return resp;
	}
	
	public static Response deleteUser(String userName)
	{
		Response resp =given()
			.pathParam("username", userName)
		
		.when()
			.post(Routes.delete_url);
		
		return resp;
		
	}

}
