package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker fake;
	User userPayload;
	
	@BeforeClass
	public void setupData()
	{
		fake = new Faker();
		userPayload = new User();
		
		userPayload.setId(fake.idNumber().hashCode());
		userPayload.setUsername(fake.name().username());
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		userPayload.setPassword(fake.internet().password(5,10));
		userPayload.setPhone(fake.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response resp = UserEndPoints.createUser(userPayload);
		resp.then().log().all();
		
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		Response resp = UserEndPoints.readUser(this.userPayload.getUsername());
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(),200);

	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		//update data using payload
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		
		
		Response resp = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		resp.then().log().all();
		
		Assert.assertEquals(resp.getStatusCode(),200);
		
		//Checking data after update
		Response respAfterupdate=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response resp = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
