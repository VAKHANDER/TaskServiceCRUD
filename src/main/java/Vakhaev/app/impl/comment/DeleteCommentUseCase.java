package Vakhaev.app.impl.comment;

import Vakhaev.adapter.persistence.comment.CommentRepository;
import Vakhaev.app.api.comment.DeleteCommentInbound;
import Vakhaev.domain.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentUseCase implements DeleteCommentInbound {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public String execute(Long commentId) {
        try{
            Comment comment = commentRepository.getCommentById(commentId);

            commentRepository.delete(comment);

            return "deleted successfully";
        } catch (Exception e){
            return "error during deleting";
        }
    }
}
