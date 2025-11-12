package dev.matheuslf.desafio.inscritos.controller.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ProjectRequestDTO(
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {}
