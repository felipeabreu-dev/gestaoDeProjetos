package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.controller.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper mapper;

    public void createTask(TaskRequestDTO dto) {
        if(!projectRepository.existsById(dto.projectId())) throw new IllegalArgumentException("Projeto não existe");

        Task task = mapper.toEntity(dto);
        task.setProjectId(projectRepository.findById(dto.projectId()).get());
        taskRepository.save(task);
    }

}
