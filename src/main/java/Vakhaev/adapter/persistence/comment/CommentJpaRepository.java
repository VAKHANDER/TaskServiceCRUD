package Vakhaev.adapter.persistence.comment;

import Vakhaev.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.taskId = :taskId")
    List<Comment> getCommentsByTaskId(Long taskId);
}
