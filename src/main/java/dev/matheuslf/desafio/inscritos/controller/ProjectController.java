package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody @Valid ProjectRequestDTO dto) {
        projectService.createProject(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
