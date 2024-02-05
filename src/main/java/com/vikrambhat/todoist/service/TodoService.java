package com.vikrambhat.todoist.service;

import com.vikrambhat.todoist.model.Todo;
import com.vikrambhat.todoist.model.dto.TodoDto;
import com.vikrambhat.todoist.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Todo createTodo(String title, String description) {
        Todo todo = new Todo(title, description);
        return todoRepository.save(todo);
    }
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Todo found with given id: "+id));
    }

    @Transactional
    public Todo updateTodo(Long id, TodoDto updateTodoDto) {
        Todo todo = getTodoById(id);
        if(updateTodoDto.getTitle()!=null) {
            todo.setTitle(updateTodoDto.getTitle());
        }
        if(updateTodoDto.getDescription()!=null) {
            todo.setDescription(updateTodoDto.getDescription());
        }
        if(updateTodoDto.isComplete()!=null) {
            todo.setComplete(updateTodoDto.isComplete());
        }
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Long id, String title, String description, boolean isComplete) {
        Todo todo = getTodoById(id);
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setComplete(isComplete);
        return todoRepository.save(todo);
    }
    @Transactional
    public Todo updateTodo(Long id, String title) {
        Todo todo = getTodoById(id);
        todo.setTitle(title);
        return todoRepository.save(todo);
    }
    @Transactional
    public Todo updateTodo(String description, Long id) {
        Todo todo = getTodoById(id);
        todo.setDescription(description);
        return todoRepository.save(todo);
    }
    @Transactional
    public Todo updateTodo(Long id, boolean isComplete) {
        Todo todo = getTodoById(id);
        todo.setComplete(isComplete);
        return todoRepository.save(todo);
    }
    @Transactional
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
