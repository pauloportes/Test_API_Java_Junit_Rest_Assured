package dev.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;


public class Put_Update extends Base {
	
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
	  public void mustSuccessfulllyPutUpdate() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
		 .when()
		 	.put("/users/"+ ID)
		 .then()
		 	.statusCode(200)
		 	.body("name", is("morpheus"))
		 	.body("job", is("zion resident"))
		 	.body("updatedAt", is(notNullValue()));	  	
	  }
	  
	  @Test
	  public void mustFailToPutUpdateWithInvalidBody() {
		
		  given()
		  	.body("{\"age\": \"morpheus\", \"city\": \"zion resident\"}")
		 .when()
		 	.put("/users/" + ID)
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Invalid data"));
	  }
	  
	  @Test
	  public void mustFailToPutUpdateEmptyValuesBody() {
		
		  given()
		  	.body("{\"name\": \"\", \"job\": \"\"}")
		 .when()
		 	.put("/users/" + ID)
		 .then()
		 	.statusCode(400)
		 	.body("error", is("name and  job are required")); 		  
	  }
	  
	  @Test
	  public void mustFailToPutUpdateNonExistentId() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
		 .when()
		 	.put("/users/" + ID_NOT_FOUND)
		 .then()
		 	.statusCode(404); 	
	  }	  
	  
	  @Test
	  public void mustSuccessfullyPutUpdateForOneParameter() {
		
		  given()
		  	.body("{\"name\": \"morpheus\"}")
		 .when()
		 	.put("/users/" + ID)
		 .then()
		 	.statusCode(200)
		 	.body("name", is("morpheus"))
		 	.body("updatedAt", is(notNullValue()));
	  }		
	  
	  @Test
	  public void mustFailToPutUpdateWithoutId() {
		
		  given()
		  	.body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
		 .when()
		 	.put("/users/")
		 .then()
		 	.statusCode(405);
	  }		 	  
}
