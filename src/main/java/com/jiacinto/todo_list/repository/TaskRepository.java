package com.jiacinto.todo_list.repository;

import com.jiacinto.todo_list.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    // les méthodes CRUD (find, create, update, delete) sont héritées de JpaRepository
    
    // Retourne les tâches dont la date limite (dueDate) est dépassée et qui ne sont pas terminées (completed = false)
    List<Task> findByDueDateBeforeAndCompletedFalse(LocalDate dueDate);

}