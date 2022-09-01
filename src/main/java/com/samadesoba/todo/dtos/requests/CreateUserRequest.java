package com.samadesoba.todo.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	private String name;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
}
