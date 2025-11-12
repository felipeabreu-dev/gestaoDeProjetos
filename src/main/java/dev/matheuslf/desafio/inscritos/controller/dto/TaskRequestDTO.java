package dev.matheuslf.desafio.inscritos.controller.dto;

import dev.matheuslf.desafio.inscritos.model.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;

public record TaskRequestDTO(
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 5, max = 150, message = "O campo precisa ter entre 5 e 150 caracteres")
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate dueDate,
        @NotNull(message = "Campo obrigatório")
        Long projectId
) {}
