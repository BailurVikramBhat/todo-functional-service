package com.vikrambhat.todoist.controller;

import com.vikrambhat.todoist.model.Todo;
import com.vikrambhat.todoist.model.dto.TodoDto;
import com.vikrambhat.todoist.service.TodoService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid TodoDto createTodoDto) {
        Todo createdTodo = todoService.createTodo(createTodoDto.getTitle(), createTodoDto.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody @Valid TodoDto updateTodoDto) throws BadRequestException {
        Todo updatedTodo = todoService.updateTodo(id, updateTodoDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

}
