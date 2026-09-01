package com.jiacinto.todo_list.service;

import com.jiacinto.todo_list.entity.Task;
import com.jiacinto.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    // reférence le repository utilisé par le service pour accéder aux données des tâches
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // récupère toutes les tâches
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //recupère une tâche par son identifiant (id) et retourne une erreur 404 si elle n'existe pas
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> 
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
                );
    }

    // crée et enregistre une nouvelle tâche 
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    // marque une taâche comme terminée (completed = true)
    public Task completeTask(Long id){
        Task task = getTaskById(id);
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    // recupère les tâches dont la date limite (dueDate) est dépassée et non terminées
    public List<Task> getOverdueTasks(){
        return taskRepository.findByDueDateBeforeAndCompletedFalse(LocalDate.now());
    }
}
