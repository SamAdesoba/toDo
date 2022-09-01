package com.samadesoba.todo;

import com.samadesoba.todo.dtos.requests.CreateUserRequest;
import com.samadesoba.todo.dtos.requests.LoginRequest;
import com.samadesoba.todo.dtos.responses.CreateUserResponse;
import com.samadesoba.todo.dtos.responses.LoginResponse;
import com.samadesoba.todo.exceptions.toDoException;
import com.samadesoba.todo.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	@DisplayName("create a user")
	public void createUserTest() throws toDoException {
		CreateUserRequest createUserRequest = new CreateUserRequest();
		createUserRequest.setName("Adesoba");
		createUserRequest.setUserName("Sam");
		createUserRequest.setEmail("ade@gmail.com");
		createUserRequest.setPassword("1234");
		createUserRequest.setConfirmPassword("1234");
		CreateUserResponse response = userService.createUser(createUserRequest);
		assertNotNull(response);
		assertEquals("Adesoba has been created successfully",response.getMessage());
	}

	@Test
	@DisplayName("login user")
	public void loginUserTest() throws toDoException {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setEmail("ade@gmail.com");
		loginRequest.setPassword("1234");
		LoginResponse loginResponse = userService.login(loginRequest);
		assertEquals("Welcome Adesoba", loginResponse.getMessage());

	}

}
