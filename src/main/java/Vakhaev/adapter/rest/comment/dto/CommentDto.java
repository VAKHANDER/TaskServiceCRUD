package Vakhaev.adapter.rest.comment.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentDto {
    private Long taskId;
    private Long initiatorId;
    private String comment;
}
