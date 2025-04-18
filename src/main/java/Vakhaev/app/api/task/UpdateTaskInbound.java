package Vakhaev.app.api.task;

public interface UpdateTaskInbound {
    String execute(Long id, String name, String priority, String approverLogin, String status, String description);
}
