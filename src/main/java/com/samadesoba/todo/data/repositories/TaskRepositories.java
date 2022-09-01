package com.samadesoba.todo.data.repositories;

import com.samadesoba.todo.data.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositories extends JpaRepository<Task, Long> {
}
