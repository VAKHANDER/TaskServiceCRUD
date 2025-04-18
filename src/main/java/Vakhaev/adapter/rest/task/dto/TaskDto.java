package Vakhaev.adapter.rest.task.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskDto {
    private String name;
    private String priority;
    private String initiatorLogin;
    private String approverLogin;
    private String status;
    private String description;
}
