package dev.restapi;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get_Single_User extends Base{

	private static int ID = 2;	
		
	@Test
		public void mustSuccessfullyGetSingleUser() {
    
			given()
			.when()
				.get("/users/"+ID)
		    .then()
		    	.statusCode(200)
		    	.body("data.id", is(2))
		    	.body("data.email", is("janet.weaver@reqres.in"))
		    	.body("data.first_name", is("Janet"))
		    	.body("data.avatar", is("https://reqres.in/img/faces/2-image.jpg"))
		    	.body("support.url", is("https://reqres.in/#support-heading"))
		    	.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));  
		}  
  
  
		@Test
		public void mustFailToGetSingleUserInformingLetterAsId() {
    
			given()
			.when()
				.get("/users/A")
			.then()
				.statusCode(404)
				.body("isEmpty()", is(true)); 
		}		
		
		@Test
		public void mustFailToGetSingleUserInformingSpecialCharactersAsId() {
    
			given()
			.when()
				.get("/users/A")
			.then()
				.statusCode(404)
				.body("isEmpty()", is(true)); 
		}
		
		@Test
		public void mustFailToGetSingleUserWithoutInformingId() {
    
			given()
			.when()
				.get("/users/")
			.then()
				.statusCode(405); 
		}	
}
