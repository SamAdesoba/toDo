package com.samadesoba.todo.MockTest;

import com.samadesoba.todo.data.models.User;
import com.samadesoba.todo.data.repositories.UserRepository;
import com.samadesoba.todo.services.UserService;
import com.samadesoba.todo.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserService userService;
	@Mock
	private ArgumentCaptor<User> userArgumentCaptor;

	@BeforeEach
	void setUp(){
		userService = new UserServiceImpl(userRepository);
	}

	@Test
	void testThatAUserCanBeCreated(){

	}
}
