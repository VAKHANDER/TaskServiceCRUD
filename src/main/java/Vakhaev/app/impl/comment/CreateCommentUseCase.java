package Vakhaev.app.impl.comment;

import Vakhaev.adapter.persistence.comment.CommentRepository;
import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.app.api.comment.CreateCommentInbound;
import Vakhaev.domain.comment.Comment;
import Vakhaev.domain.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentUseCase implements CreateCommentInbound {
    private final CommentRepository commentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public String execute(Long taskId, Long initiatorId, String comm) {
        try {
            Employee employee = employeeRepository.findById(initiatorId);
            Comment comment = new Comment(taskId, employee, comm);

            commentRepository.save(comment);
            return "New commentary was added!";
        } catch (Exception e){
            return "error during commentary creating";
        }
    }
}
