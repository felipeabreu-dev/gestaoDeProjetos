package dev.matheuslf.desafio.inscritos.controller.dto;

import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.model.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.model.enums.TaskStatus;

import java.time.LocalDate;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate dueDate,
        Project projectId
) {}
