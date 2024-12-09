package api.endpoints;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

public class UserEndPoints2 {
	
	//method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");	//Load the Properties File
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		
		String post_url = getURL().getString("post_url");
		
		Response resp =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(post_url);
		
		return resp;
		
	}
	
	public static Response readUser(String userName)
	{
		String get_url = getURL().getString("get_url");
		
		Response resp =given()
			.pathParam("username",userName)
		
		.when()
			.post(get_url);
		
		return resp;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		String update_url = getURL().getString("update_url");
		
		Response resp =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName)
			.body(payload)
		
		.when()
			.post(update_url);
		
		return resp;
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url = getURL().getString("delete_url");
		
		Response resp =given()
			.pathParam("username", userName)
		
		.when()
			.post(delete_url);
		
		return resp;
		
	}

}
