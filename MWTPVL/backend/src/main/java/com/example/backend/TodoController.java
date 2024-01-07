package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService taskService;

    @Autowired
    public TodoController(TodoService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Todo> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Todo getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/")
    public Todo createTask(@RequestBody Todo task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Todo updateTask(@PathVariable Long id, @RequestBody Todo task) {
        return taskService.updateTask(id, task);
    }
}
