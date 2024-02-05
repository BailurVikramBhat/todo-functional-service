package com.vikrambhat.todoist.repository;

import com.vikrambhat.todoist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
