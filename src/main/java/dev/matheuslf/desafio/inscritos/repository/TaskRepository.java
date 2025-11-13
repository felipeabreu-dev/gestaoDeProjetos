package dev.matheuslf.desafio.inscritos.repository;

import dev.matheuslf.desafio.inscritos.controller.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.model.Task;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {}
