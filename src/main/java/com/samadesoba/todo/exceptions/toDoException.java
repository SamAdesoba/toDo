package com.samadesoba.todo.exceptions;

public class toDoException extends Exception {
	private int statusCode;
	public toDoException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
