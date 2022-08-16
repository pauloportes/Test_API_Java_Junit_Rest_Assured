package dev.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.junit.Test;


public class Get_Single_User_Not_Found extends Base {

	private static long ID_NOT_FOUND = System.nanoTime();
	
	  @Test
	  public void mustFailToGetSingleNonExistantId() {
	    
		 given()
		 .when()
		 	.get("/users/"+ID_NOT_FOUND)
		 .then()
		 	.statusCode(404)
		 	.body("isEmpty()", is(true));  
	  }  
	
}
