package Vakhaev.app.impl.task;

import Vakhaev.adapter.persistence.task.TaskRepository;
import Vakhaev.app.api.task.FindTaskByIdInbound;
import Vakhaev.domain.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindTaskByIdUseCase implements FindTaskByIdInbound {
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public Task execute(Long id) {
        return taskRepository.findTaskById(id);
    }
}
