package dev.matheuslf.desafio.inscritos.controller.dto;

import dev.matheuslf.desafio.inscritos.model.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record TaskUpdateRequestDTO(
        @NotNull(message = "Campo obrigatório")
        TaskStatus status
) {}
