package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.controller.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        task.setDueDate(dto.dueDate());

        return task;
    }

}
