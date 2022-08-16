package dev.restapi.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dev.restapi.Delete;
import dev.restapi.Get_List_Users;
import dev.restapi.Get_Single_User;
import dev.restapi.Get_Single_User_Not_Found;
import dev.restapi.Post_Create;
import dev.restapi.Post_Login_Successful;
import dev.restapi.Post_Login_Unsuccessful;
import dev.restapi.Put_Update;

@RunWith(Suite.class)
@SuiteClasses({
	Get_Single_User.class,
	Get_Single_User_Not_Found.class,
	Post_Create.class,
	Put_Update.class,
	Delete.class,
	Post_Login_Successful.class,
	Post_Login_Unsuccessful.class,
	Get_List_Users.class
})
public class Test_Suite {

}
