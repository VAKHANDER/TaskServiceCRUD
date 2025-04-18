package Vakhaev.app.api.task;

public interface CreateTaskInbound {
    String execute(String name, String priority, String initiatorLogin, String approverLogin, String status, String description);
}
