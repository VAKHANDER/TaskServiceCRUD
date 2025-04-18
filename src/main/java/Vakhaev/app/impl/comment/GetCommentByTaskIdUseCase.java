package Vakhaev.app.impl.comment;

import Vakhaev.adapter.persistence.comment.CommentRepository;
import Vakhaev.app.api.comment.GetCommentByTaskIdInbound;
import Vakhaev.domain.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCommentByTaskIdUseCase implements GetCommentByTaskIdInbound {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public List<Comment> execute(Long taskId) {
        return commentRepository.getCommentsByTaskId(taskId);
    }
}
