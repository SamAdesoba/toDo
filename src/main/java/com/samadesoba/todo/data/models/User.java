package com.samadesoba.todo.data.models;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	private String userName;

	@Email
	@Column(unique = true)
	private String email;

	private String password;
	private String confirmPassword;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime date = LocalDateTime.now();

}



