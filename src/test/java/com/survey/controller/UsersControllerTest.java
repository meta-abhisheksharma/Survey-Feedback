package java.com.survey.controller;

import static org.junit.Assert.*;

import java.com.survey.facade.UsersFacade;
import java.com.survey.model.Users;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UsersControllerTest {

	
	@Autowired
	UsersFacade usersFacade;
	
	@Test
	public void testGetAll() {
		List<Users> users = usersFacade.getAll();
		
		Users user1 = new Users();
		user1.setName("mandeep");
		
		List<Users> expectedUsers = new ArrayList<Users>();
		expectedUsers.add(user1);
		
		assertEquals(expectedUsers.get(0), users.get(0));
		
	}
	
	@Test
	public void testGetByID() {
		Users actual_user = usersFacade.getByID("10");
		
		Users expected_user = new Users();
		expected_user.setName("mandeep");
		expected_user.setUserId("U100001");
		
		
		
		assertEquals(expected_user, actual_user);
		
	}

}
