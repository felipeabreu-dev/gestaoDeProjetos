package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.controller.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.controller.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.controller.dto.TaskUpdateRequestDTO;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.model.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.model.enums.TaskStatus;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import dev.matheuslf.desafio.inscritos.repository.specs.TaskSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.matheuslf.desafio.inscritos.repository.specs.TaskSpecs.*;

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

    public List<TaskResponseDTO> getTasks(TaskStatus status, TaskPriority priority, Long projectId) {

        Specification<Task> specs = (root, query, cb) -> cb.conjunction();

        if(status != null) {
            specs = specs.and(statusEqual(status));
        }

        if(priority != null) {
            specs = specs.and(priorityEqual(priority));
        }

        if(projectId != null) {
            Project project = getProjectById(projectId);
            specs = specs.and(TaskSpecs.projectIdEqual(project));
        }

        return taskRepository.findAll(specs)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public TaskResponseDTO updateTaskStatus(Long id, TaskUpdateRequestDTO dto) {
        if (!taskRepository.existsById(id)) throw new RuntimeException();

        Task task = taskRepository.findById(id).get();
        task.setStatus(dto.status());
        taskRepository.save(task);

        return mapper.toDTO(task);
    }

    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)) throw new RuntimeException();
        taskRepository.deleteById(id);
    }

    Project getProjectById(Long id) {
        return projectRepository.findById(id).get();
    }

}
