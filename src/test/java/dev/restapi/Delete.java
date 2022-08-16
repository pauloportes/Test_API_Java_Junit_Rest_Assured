package dev.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;


public class Delete extends Base {
	
	private static long ID_NOT_FOUND = System.nanoTime();
	private String ID;

	@Before
	public void exractNewID( ) {
		
		ID = given()
	  	.body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
	 .when()
	 	.post("/users")
	 .then()
	 	.statusCode(201)
	 	.body("name", is("morpheus"))
	 	.body("job", is("leader"))
	 	.body("id", is(notNullValue()))
	 	.body("createdAt", is(notNullValue()))
	 	.extract().path("id");		
	} 

	@Test
	  public void mustSuccessfullyDelete() {
		 
		  given()
		 .when()
		 	.delete("/users/"+ ID)
		 .then()
		 	.statusCode(204); 	  	
	  } 
	
	@Test
	  public void mustFailToDeleteTheSameId() {
		
		given()
		 .when()
		 	.delete("/users/"+ ID)
		 .then()
		 	.log().all()
		 	.statusCode(204);
		  
			given()	  	
		 .when()
		 	.delete("/users/"+ ID)
		 .then()
		 	.statusCode(404);	  	
	  } 
	
	
	@Test
	  public void mustFailToDeleteWithoutInformingId() {
		
		  given()	  	
		 .when()
		 	.delete("/users/")
		 .then()
		 	.statusCode(405); 	  	
	  } 
	
	@Test
	  public void mustFailToDeleteNonExistentId() {
		
		  given()	  	
		 .when()
		 	.delete("/users/"+ ID_NOT_FOUND)
		 .then()
		 	.statusCode(404); 	  	
	  } 
	
	@Test
	  public void mustFailToDeleteInformingLetterAsId() {
		
		  given()	  	
		 .when()
		 	.delete("/users/A")
		 .then()
		 	.statusCode(404); 	  	
	  } 
	
	@Test
	  public void mustFailToDeleteInformingSpecialCharactersAsId() {
		
		  given()	  	
		 .when()
		 	.delete("/users/#")
		 .then()
		 	.statusCode(404); 
	  } 
} 
