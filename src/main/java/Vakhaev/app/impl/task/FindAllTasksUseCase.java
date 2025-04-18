package Vakhaev.app.impl.task;

import Vakhaev.adapter.persistence.task.TaskRepository;
import Vakhaev.app.api.task.FindAllTasksInbound;
import Vakhaev.domain.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllTasksUseCase implements FindAllTasksInbound {
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public List<Task> execute() {
        return taskRepository.findAllTasks();
    }
}
