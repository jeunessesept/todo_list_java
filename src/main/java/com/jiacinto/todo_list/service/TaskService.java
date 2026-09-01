package com.jiacinto.todo_list.service;

import com.jiacinto.todo_list.entity.Task;
import com.jiacinto.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> 
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
                );
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task completeTask(Long id){
        Task task = getTaskById(id);
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
