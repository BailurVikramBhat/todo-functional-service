package com.vikrambhat.todoist.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoDto {

    @NotBlank(message = "Title is required.")
    @Size(min = 3, max=50, message = "Title should be between 3-50 characters.")
    private String title;
    @Size(max = 255, message = "Description cannot exceed 255 characters.")
    private String description;
    private Boolean complete;

    public TodoDto(String title, String description, Boolean isComplete) {
        this.title = title;
        this.description = description;
        this.complete = isComplete;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isComplete() {
        return complete;
    }
}
