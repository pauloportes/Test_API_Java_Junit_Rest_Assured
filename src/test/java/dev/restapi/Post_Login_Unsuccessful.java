package dev.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.junit.Test;


public class Post_Login_Unsuccessful extends Base {


	  @Test
	  public void mustUnsuccessfullyLoginWithoutPassword() {
		
		  given()
		  	.body("{\"email\": \"paul.holt@reqres.in\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing password"));		 	 	
	  } 	
	  
	  @Test
	  public void mustUnsuccessfullyLoginWithoutEmail() {
		
		  given()
		  	.body("{\"password\": \"cityslicka\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing email or username"));		 	 	
	  } 
	
	  @Test
	  public void mustUnsuccessfullyLoginWithoutEmailAndPassword() {
		
		  given()
		  	.body("{}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing email or username and password"));		 	 	
	  } 
	  
	  @Test
	  public void mustUnsuccessfullyLoginJustInformingUsername() {
		
		  given()
		  	.body("{\"username\": \"paultest\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing password"));		 	 	
	  }
	  
	  @Test
	  public void mustUnsuccessfullyLoginInformingUsernameAndEmail() {
		
		  given()
		  	.body("{\"username\": \"paultest\", \"email\": \"eve.holt@reqres.in\"}")
		 .when()
		 	.post("/login")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing password"));		 	 	
	  } 
}
