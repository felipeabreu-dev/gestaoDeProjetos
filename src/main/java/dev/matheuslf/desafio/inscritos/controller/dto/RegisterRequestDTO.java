package dev.matheuslf.desafio.inscritos.controller.dto;

import dev.matheuslf.desafio.inscritos.model.enums.UserRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDTO(
        @NotBlank(message = "Campo obrigatório")
        String login,
        @NotBlank(message = "Campo obrigatório")
        String password,
        @NotNull(message = "Campo obrigatório")
        UserRoles role
) {}
