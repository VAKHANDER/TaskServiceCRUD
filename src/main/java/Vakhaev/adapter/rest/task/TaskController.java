package Vakhaev.adapter.rest.task;

import Vakhaev.adapter.rest.task.dto.TaskDto;
import Vakhaev.app.api.task.*;
import Vakhaev.domain.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TMS-rest/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final FindAllTasksInbound findAllTasksInbound;
    private final FindTaskByIdInbound findTaskByIdInbound;
    private final CreateTaskInbound createTaskInbound;
    private final DeleteTaskInbound deleteTaskInbound;
    private final UpdateTaskInbound updateTaskInbound;

    @GetMapping("/get-all-tasks")
    public List<Task> findAllTasks(){
        return findAllTasksInbound.execute();
    }

    @GetMapping("/get-task-{id}")
    public Task findTask(@PathVariable Long id){
        return findTaskByIdInbound.execute(id);
    }

    @PostMapping("/create-task")
    public String createTask(@RequestBody TaskDto taskDto){
        return createTaskInbound.execute(taskDto.getName(),
            taskDto.getPriority(),
            taskDto.getInitiatorLogin(),
            taskDto.getApproverLogin(),
            taskDto.getStatus(),
            taskDto.getDescription());
    }

    @DeleteMapping("/delete-task-{id}")
    public String deleteTask(@PathVariable Long id){
        return deleteTaskInbound.execute(id);
    }

    @PostMapping("/update-task-{id}")
    public String updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto){
        return updateTaskInbound.execute( id,
            taskDto.getName(),
            taskDto.getPriority(),
            taskDto.getApproverLogin(),
            taskDto.getStatus(),
            taskDto.getDescription()
        );
    }
}
