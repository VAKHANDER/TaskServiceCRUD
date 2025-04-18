package Vakhaev.app.impl.task;

import Vakhaev.adapter.persistence.task.TaskRepository;
import Vakhaev.app.api.task.DeleteTaskInbound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteTaskByIdUseCase implements DeleteTaskInbound {
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public String execute(Long id) {
        try {
            taskRepository.delete(id);
            return "Task was successfully deleted!";
        } catch (Exception e){
            return "Error during task delete!";
        }
    }
}
