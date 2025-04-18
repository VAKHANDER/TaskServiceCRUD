package Vakhaev.app.api.comment;

public interface CreateCommentInbound {
    String execute(Long taskId, Long initiatorId, String comm);
}
