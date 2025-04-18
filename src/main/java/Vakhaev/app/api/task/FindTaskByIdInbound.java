package Vakhaev.app.api.task;

import Vakhaev.domain.task.Task;

public interface FindTaskByIdInbound {
    Task execute(Long id);
}
