package attsd.exam.spring.loginservice.project.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import attsd.exam.spring.loginservice.project.controllers.LoginController;
import attsd.exam.spring.loginservice.project.model.User;
import attsd.exam.spring.loginservice.project.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {
	
	@MockBean
	private UserService userService;

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetLoginPage() throws Exception {
		mvc.perform(get("/login"))
				.andExpect(view().name("login")).andExpect(status().isOk());
	}
	
	
	@Test
	public void testGetSignupPage() throws Exception {
		mvc.perform(get("/signup"))
				.andExpect(view().name("signup")).andExpect(status().isOk());
	}

	@Test
	public void testNewUserWhenUserNotExists() throws Exception {
		User user = new User();
		user.setEmail("email");
		user.setPassword("pass");
		user.setUsernumber("9999");
		user.setUsername("user");
		mvc.perform(post("/signup")
				.param("email", user.getEmail()).param("username", user.getUsername()).param("usernumber", user.getUsernumber()).param("password", user.getPassword()))
		.andExpect(view().name("login"))
		.andExpect(status().isOk());
;
	}
	
	@Test
	public void testNewUserWhenUserExists() throws Exception {
		User user = new User();
		user.setEmail("Jose@gmail");
		user.setPassword("pass");
		user.setUsernumber("9999");
		user.setUsername("Jose");
		when(userService.findUserByEmail("jose@gmail")).thenReturn(user);
		User user2 = new User();
		user2.setEmail("jose@gmail");
		user.setPassword("password");
		user.setUsernumber("99");
		user.setUsername("jose10");
		mvc.perform(post("/signup")
				.param("email", user2.getEmail()).param("username", user2.getUsername()).param("password", user2.getPassword()).param("usernumber", user2.getUsernumber()))
		.andExpect(view().name("error"))
		.andExpect(status().isOk());
	}
	
	
}
