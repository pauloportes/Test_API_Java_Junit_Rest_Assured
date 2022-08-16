package dev.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class Post_Login_Successful extends Base {

	  @Test
	  public void mustSuccessfullyLogin() {			
			
		  given()
		  	.body("{\"username\": \"paultest\", \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(200)
		 	.body("token", is(notNullValue()));		 	 	
	  } 
	  
	  @Test
	  public void mustSuccessfullyLoginInformingEmailAndPassword() {
		
		  given()
		  	.body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(200)
		 	.body("token", is(notNullValue()));		 	 	
	  }
	  
	  @Test
	  public void mustSuccessfullyLoginInformingUsernameAndPassword() {
		
		  given()
		  	.body("{\"username\": \"paultest\", \"password\": \"cityslicka\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(200)
		 	.body("token", is(notNullValue()));		 	 	
	  }
}
