package com.jiacinto.todo_list.controller;

import com.jiacinto.todo_list.entity.Task;
import com.jiacinto.todo_list.service.TaskService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // endpoint pour récupérer toutes les tâches
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // endpoint pour récupérer une tâche par son identifiant (id)
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // endpoint pour créer une nouvelle tâche
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    // endpoint pour update une tâche comme terminée
    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        return taskService.completeTask(id);
    }

    // endpoint pour récupérer les tâches en retard
    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }
}
