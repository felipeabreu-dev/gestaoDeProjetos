package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.controller.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.controller.dto.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.exception.ProjectNonExistsException;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper mapper;

    public void createProject(ProjectRequestDTO dto) {
        Project project = mapper.toEntity(dto);
        projectRepository.save(project);
    }

    public List<ProjectResponseDTO> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNonExistsException("Projeto não encontrado"));
    }

    public boolean existsProjectById(Long id) {
        return projectRepository.existsById(id);
    }
}
