package dev.restapi;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import static org.hamcrest.Matchers.*;


public class Post_Create extends Base {

	
	  @Test
	  public void mustSuccessfullyCreateUser() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
		 .when()
		 	.post("/users")
		 .then()
		 	.statusCode(201)
		 	.body("name", is("morpheus"))
		 	.body("job", is("leader"))
		 	.body("id", is(notNullValue()))
		 	.body("createdAt", is(notNullValue()));	  	
	  } 
	  
	  @Test
	  public void mustFailToCreateTheSameUser() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
		 .when()
		 	.post("/users")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("This user already exists"));	  	
	  } 
	  
	  @Test
	  public void mustFailToCreateUserWhithoutNameParameter() {
		
		  given()
		  	.body("{\"job\": \"leader\"}")
		 .when()
		 	.post("/users")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing name"));	
	  }
	  
	  @Test
	  public void mustFailToCreateUserWhithoutJobParameter() {
		
		  given()
		  	.body("{\"name\": \"morpheus\"}")
		 .when()
		 	.post("/users")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Missing job"));	
	  } 
	  
	  @Test
	  public void mustFailToCreateUserWhithoutInformingParameterValues() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
		 .when()
		 	.post("/users")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("name and  job are required")); 		  
	  }	  
	}
