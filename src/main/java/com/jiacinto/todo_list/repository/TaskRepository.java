package com.jiacinto.todo_list.repository;

import com.jiacinto.todo_list.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    // les méthodes CRUD (find, create, update, delete) sont héritées de JpaRepository
}