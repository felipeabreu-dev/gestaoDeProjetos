package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody @Valid TaskRequestDTO dto) {
        taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
