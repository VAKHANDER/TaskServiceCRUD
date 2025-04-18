package Vakhaev.app.api.comment;

public interface UpdateCommentInbound {
    String execute(Long commentId, Long taskId, Long initiatorId, String comm);
}
