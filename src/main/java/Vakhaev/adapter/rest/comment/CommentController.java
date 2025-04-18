package Vakhaev.adapter.rest.comment;

import Vakhaev.adapter.rest.comment.dto.CommentDto;
import Vakhaev.app.api.comment.CreateCommentInbound;
import Vakhaev.app.api.comment.DeleteCommentInbound;
import Vakhaev.app.api.comment.GetCommentByTaskIdInbound;
import Vakhaev.app.api.comment.UpdateCommentInbound;
import Vakhaev.domain.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TMS-rest/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CreateCommentInbound createCommentInbound;
    private final GetCommentByTaskIdInbound getCommentByTaskIdInbound;
    private final UpdateCommentInbound updateCommentInbound;
    private final DeleteCommentInbound deleteCommentInbound;

    @PostMapping("/create-comment")
    public String createComment(@RequestBody CommentDto commentDto){
        return createCommentInbound.execute(commentDto.getTaskId(),
            commentDto.getInitiatorId(),
            commentDto.getComment());
    }

    @GetMapping("/get-comments-{taskId}")
    public List<Comment> getCommentsByTaskId(@PathVariable Long taskId){
        return getCommentByTaskIdInbound.execute(taskId);
    }

    @PostMapping("/update-comment-{commentId}")
    public String updateCommentById(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return updateCommentInbound.execute(commentId, commentDto.getTaskId(),
            commentDto.getInitiatorId(),
            commentDto.getComment());
    }

    @DeleteMapping("/delete-comment-{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        return deleteCommentInbound.execute(commentId);
    }
}
