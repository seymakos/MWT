package com.example.backend;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository taskRepository;

    @Autowired
    public TodoService(TodoRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Todo> getAllTasks() {
        return taskRepository.findAll();
    }

    public Todo getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Todo createTask(Todo task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Todo updateTask(Long id, Todo updatedTask) {
        Todo existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask != null) {
            existingTask.setName(updatedTask.getName());
            existingTask.setPriority(updatedTask.getPriority());
            return taskRepository.save(existingTask);
        }

        return null; 
    }
}