package Vakhaev.app.api.task;

import Vakhaev.domain.task.Task;

import java.util.List;

public interface FindAllTasksInbound {
    List<Task> execute();
}
