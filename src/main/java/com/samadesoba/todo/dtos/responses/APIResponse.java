package com.samadesoba.todo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse implements Serializable {
	private String status;
	private String message;
	private Object data;
	private int result;

}
