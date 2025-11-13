package dev.matheuslf.desafio.inscritos.controller.dto;

public record ErrorResponseDTO(
        Integer status,
        String message
) {}
