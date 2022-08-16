package dev.restapi;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get_List_Users extends Base {
	
	  @Test
	  public void mustSuccessfullyGetListUsersInformingParameterEqualTo1() {
		
		  given()
		 .when()
		 	.get("/users?page=1")
		 .then()
		 	.statusCode(200)
		 	.body("page", is(1)) 
		 	.body("per_page", is(6)) 
		 	.body("total", is(12)) 
		 	.body("total_pages", is(2))
		 	.body("support.url", is("https://reqres.in/#support-heading"))
		 	.body("data", is(notNullValue()))
		 	.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));  
	  } 
	  
	  @Test
	  public void mustSuccessfullyGetListUsersInformingParameterEqualTo2() {
		
		 given()
		 .when()
		 	.get("/users?page=2")
		 .then()
		 	.statusCode(200) 
		 	.body("page", is(2)) 
		 	.body("per_page", is(6)) 
		 	.body("total", is(12)) 
		 	.body("total_pages", is(2))
		 	.body("data", is(notNullValue()))
		 	.body("support.url", is("https://reqres.in/#support-heading"))
		 	.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));  
		 	; 
	  }
	  
	  @Test
	  public void mustFailToGetListUsersInformingNonExistentId() {
	    
		 given()
		 .when()
		 	.get("/users?page=3")
		 	.then()
		 	.statusCode(404)
		 	.body("isEmpty()", is(true));
	  }
	  
	  @Test
	  public void mustFailToGetListUsersInformingParameterEqualTo0() {
	    
		 given()
		 .when()
		 	.get("/users?page=0")
		 .then()
		 	.statusCode(404)
		 	.body("isEmpty()", is(true));	
	  }
	  
	  @Test 
	  public void mustFailToGetListUsersWithoutInformingPageParameter() {
	    
		 given()
		 .when()
		 	.get("/users?page=")
		 .then()
		 .statusCode(404)
		 	.body("isEmpty()", is(true));		 		 
	  }
	  
	  @Test
	  public void mustFailToGetListUsersInformingSpecialCharactersAsId() {
	    
		 given()
		 .when()
		 	.get("/api/users?page=#")
		 .then()
		 .statusCode(404)
		 	.body("isEmpty()", is(true));
	  }
	  
	  @Test
	  public void mustFailToGetListUSersInformingLetterAsId() {
	    
		 given()
		 .when()
		 	.get("/users?page=A")
		 .then()
		 	.statusCode(404)
		 	.body("isEmpty()", is(true)); 
	  }
	  
	  @Test
	  public void mustSuccessfullyGetListUsersInformingPerPageParameterEqualTo1() {
	    
		 given()
		 .when()
		 	.get("/users?per_page=1")
		 .then()
		 	.statusCode(200)
		 	.body("page", is(1)) 
		 	.body("per_page", is(1)) 
		 	.body("total", is(12)) 
		 	.body("total_pages", is(12))
		 	.body("support.url", is("https://reqres.in/#support-heading"))
		 	.body("data", is(notNullValue()))
		 	.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!")); 
	  }
	  
	  @Test
	  public void mustSuccessfullyGetListUsersInformingPerPageAndPageParameters() {
	    
		 given()
		 .when()
		 	.get("/users?page=1&per_page=1")
		 .then()
		 	.statusCode(200)
		 	.body("page", is(1)) 
		 	.body("per_page", is(1)) 
		 	.body("total", is(12)) 
		 	.body("total_pages", is(12))
		 	.body("support.url", is("https://reqres.in/#support-heading"))
		 	.body("data", is(notNullValue()))
		 	.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!")); 
	  }
	  
	  @Test
	  public void mustFailGetListUsersInformingPerPageParameterEqualTo0() {
	    
		 given()
		 .when()
		 	.get("/users?per_page=0")
		 .then()
		 	.statusCode(400)
		 	.body("error", is("Invalid data")); 
	  }	 
	  
	  @Test //In this project, I decided to use hamcrest's assert (from Rest Assured). But in this test case I did it with Junit's assert to exemplify.
	  public void mustSuccessfullyGetListUsersInformingPerPageParameterEqualTo2() {
	    
		  Response response = RestAssured.request(Method.GET, "https://reqres.in/api/users?per_page=2");
		  Assert.assertEquals(200, response.statusCode());
	  }	  
	  
	}
