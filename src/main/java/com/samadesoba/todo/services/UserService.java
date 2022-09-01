package com.samadesoba.todo.services;


import com.samadesoba.todo.dtos.requests.AddTaskRequest;
import com.samadesoba.todo.dtos.requests.CreateUserRequest;
import com.samadesoba.todo.dtos.requests.LoginRequest;
import com.samadesoba.todo.dtos.responses.AddTaskResponse;
import com.samadesoba.todo.dtos.responses.CreateUserResponse;
import com.samadesoba.todo.dtos.responses.LoginResponse;
import com.samadesoba.todo.exceptions.toDoException;

public interface UserService {
	CreateUserResponse createUser(CreateUserRequest createUserRequest) throws toDoException;

	LoginResponse login(LoginRequest loginRequest) throws toDoException;

	AddTaskResponse addTask(AddTaskRequest addTaskRequest);

}
