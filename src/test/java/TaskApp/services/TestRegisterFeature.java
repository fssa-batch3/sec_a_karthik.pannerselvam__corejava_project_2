package TaskApp.services;
import model.User;
import services.UserService;
import services.exception.ServiceException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class TestRegisterFeature {

	public void main(String[] args) {
		User user1 = new User("KarthikJavaTest","karthik@gmail.com","Karthik@123");
		UserService userService = new UserService();
		
		try {
			userService.registerUser(user1);
		}catch(Exception e){
			e.printStackTrace();
	}
}
	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("arunkumar","arun19@gmail.com","Arun@123");
		try {
			assertTrue(userService.registerUser(user1));
		}catch(ServiceException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	
	public void testInvalidPassword() {
		UserService userservice = new UserService();
		User user1 = new User("arunkumar","arun19@gmail.com","Arun@123");
		try {
			assertFalse(userservice.registerUser(user1));
		}
		catch(ServiceException e){
			System.out.println("InvalidPassword");
		}
	}
	
	@Test
	
	public void testUserNull() {
		UserService userService = new UserService();
		User user1 = null;
		
		try {
			assertFalse(userService.registerUser(user1));
		}catch(ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
