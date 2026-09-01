package com.jiacinto.todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank") // Nous nous assurons que le champ titre n'est ni 'null', ni vide et ne contient pas par exemple que des espaces
    private String title;

    private boolean completed;
    private LocalDate dueDate;

    // getters

    public Long getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    // setters
    // l'id est généré automatiquement par la db, donc pas besoin de définir un setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
