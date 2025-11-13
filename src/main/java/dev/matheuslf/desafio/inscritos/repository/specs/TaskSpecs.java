package dev.matheuslf.desafio.inscritos.repository.specs;

import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.model.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.model.enums.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


@RequiredArgsConstructor
public class TaskSpecs {

    public static Specification<Task> statusEqual(TaskStatus status) {
        return (root,query,cb) -> cb.equal(root.get("status"), status);
    }

    public static Specification<Task> priorityEqual(TaskPriority priority) {
        return (root,query, cb) -> cb.equal(root.get("priority"), priority);
    }

    public static Specification<Task> projectIdEqual(Project project) {
        return (root, query, cb) -> cb.equal(root.get("projectId"), project);
    }

}
