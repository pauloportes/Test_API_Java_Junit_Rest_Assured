package dev.restapi.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dev.codescreen.Delete;
import dev.codescreen.FooTest;
import dev.codescreen.Get_Single_User;
import dev.codescreen.Get_Single_User_Not_Found;
import dev.codescreen.Post_Create;
import dev.codescreen.Post_Login_Successful;
import dev.codescreen.Post_Login_Unsuccessful;
import dev.codescreen.Put_Update;

@RunWith(Suite.class)
@SuiteClasses({
	FooTest.class,
	Get_Single_User.class,
	Get_Single_User_Not_Found.class,
	Post_Create.class,
	Put_Update.class,
	Delete.class,
	Post_Login_Successful.class,
	Post_Login_Unsuccessful.class,	
})
public class Test_Suite {

}
