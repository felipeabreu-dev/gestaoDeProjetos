package dev.matheuslf.desafio.inscritos.controller.common;

import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.matheuslf.desafio.inscritos.controller.dto.ErrorResponseDTO;
import dev.matheuslf.desafio.inscritos.exception.ProjectNonExistsException;
import dev.matheuslf.desafio.inscritos.exception.TaskNonExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO runtimeExceptionHandler(RuntimeException e) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                500,
                "Erro inesperado, entre em contato com a administração"
        );
        return error;
    }

    @ExceptionHandler(ProjectNonExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO projectNonExistsExceptionHandler(ProjectNonExistsException e) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                400,
                "Erro de requisição, verifique os dados"
        );
        return error;
    }

    @ExceptionHandler(TaskNonExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO taskNonExistsExceptionHandler(TaskNonExistsException e) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                400,
                "Erro de requisição, verifique os dados"
        );
        return error;
    }

    @ExceptionHandler(JWTVerificationException.class)
    public String jwtVerificationExceptionHandler(JWTVerificationException e) {
        return "";
    }
}
