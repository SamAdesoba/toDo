package com.samadesoba.todo.services;

import com.samadesoba.todo.data.models.Task;
import com.samadesoba.todo.data.models.User;
import com.samadesoba.todo.data.repositories.UserRepository;
import com.samadesoba.todo.dtos.requests.AddTaskRequest;
import com.samadesoba.todo.dtos.requests.CreateUserRequest;
import com.samadesoba.todo.dtos.responses.AddTaskResponse;
import com.samadesoba.todo.dtos.responses.CreateUserResponse;
import com.samadesoba.todo.dtos.requests.LoginRequest;
import com.samadesoba.todo.dtos.responses.LoginResponse;
import com.samadesoba.todo.exceptions.toDoException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private final UserRepository userRepository;



	@Override
	public CreateUserResponse createUser(CreateUserRequest createUserRequest) throws toDoException {
				User user = User.builder()
				  .name(createUserRequest.getName())
				  .userName(createUserRequest.getUserName())
				  .email(createUserRequest.getEmail())
				  .password(createUserRequest.getPassword())
				  .confirmPassword(createUserRequest.getConfirmPassword()).build();

		if(!createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())) throw new toDoException("Password doesn't match", 400);

		User savedUser = userRepository.save(user);
		CreateUserResponse response = new CreateUserResponse();
		response.setMessage(savedUser.getName() + " has been created successfully");

		return response;

	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) throws toDoException {
		Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
		if(user.isPresent()){
			if(user.get().getPassword().equals(loginRequest.getPassword())){
				LoginResponse response = new LoginResponse();
				response.setMessage("Welcome "+ user.get().getName());
				return response;
			}throw new toDoException("Wrong login details", 400);
		}throw new toDoException("Wrong login details", 400);

	}

	@Override
	public AddTaskResponse addTask(AddTaskRequest addTaskRequest) {
		Task task = new Task();
		task.setTaskTitles(addTaskRequest.getTaskTitles());
		task.setTask(addTaskRequest.getTask());
		task.setSetTaskDate(addTaskRequest.getTaskDate());

		return null;
	}
}
