package Vakhaev.app.api.comment;

import Vakhaev.domain.comment.Comment;

import java.util.List;

public interface GetCommentByTaskIdInbound {
    List<Comment> execute(Long taskId);
}
