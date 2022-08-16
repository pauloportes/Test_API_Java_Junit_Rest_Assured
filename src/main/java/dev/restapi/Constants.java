package dev.restapi;

import io.restassured.http.ContentType;

public interface Constants{

	
	String APP_BASE_URL = "https://reqres.in";
	//Integer APP_PORT = 80;
	String APP_BASE_PATH = "/api";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 	5000L; 
		
	}

