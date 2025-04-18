package Vakhaev.app.impl.comment;

import Vakhaev.adapter.persistence.comment.CommentRepository;
import Vakhaev.app.api.comment.UpdateCommentInbound;
import Vakhaev.domain.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentUseCase implements UpdateCommentInbound {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public String execute(Long commentId, Long taskId, Long initiatorId, String comm) {
        try{
            Comment comment = commentRepository.getCommentById(commentId);

            comment.setTaskId(taskId);
            comment.setComm(comm);

            commentRepository.save(comment);
            return "commentary successfully updated!";
        } catch (Exception e){
            return "Error during comment update";
        }
    }
}
