package Vakhaev.adapter.persistence.comment;

import Vakhaev.domain.comment.Comment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final CommentJpaRepository commentJpaRepository;

    public List<Comment> getCommentsByTaskId(Long taskId){
        return commentJpaRepository.getCommentsByTaskId(taskId);
    }

    public Comment getCommentById(Long commentId){
        return commentJpaRepository.findById(commentId).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Comment comment){
        commentJpaRepository.save(comment);
    }

    public void delete(Comment comment){
        commentJpaRepository.delete(comment);
    }
}
