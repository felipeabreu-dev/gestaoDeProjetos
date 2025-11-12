package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.controller.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setName(dto.name());
        project.setDescription(dto.description());
        project.setStartDate(dto.startDate());
        project.setEndDate(dto.endDate());

        return project;
    }

}
