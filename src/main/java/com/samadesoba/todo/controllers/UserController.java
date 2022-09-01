package com.samadesoba.todo.controllers;
import com.samadesoba.todo.data.repositories.UserRepository;
import com.samadesoba.todo.dtos.responses.APIResponse;
import com.samadesoba.todo.dtos.requests.CreateUserRequest;
import com.samadesoba.todo.dtos.requests.LoginRequest;
import com.samadesoba.todo.dtos.responses.LoginResponse;
import com.samadesoba.todo.exceptions.toDoException;
import com.samadesoba.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import static org.springframework.http.HttpStatus.*;



@RestController
@RequestMapping("/api/v1/toDo")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;


	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody @Valid @NotNull CreateUserRequest createUserRequest) {
		try {
			var createUserResponse = userService.createUser(createUserRequest);
			APIResponse apiResponse = APIResponse.builder()
					  .status("success")
					  .message("user created successfully")
					  .data(createUserResponse)
					  .build();
			return new ResponseEntity<>(apiResponse, CREATED);
		} catch (toDoException e) {
			APIResponse apiResponse = APIResponse.builder()
					  .status("fail")
					  .message(e.getMessage())
					  .build();
			return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getStatusCode()));
		}
	}
	@GetMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) throws toDoException {
		return userService.login(loginRequest);
	}

}
