package Vakhaev.domain.comment;

import Vakhaev.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "comment_id_generator", sequenceName = "sq_comment_id", allocationSize = 1)
    private Long id;
    @Column(name = "task_id")
    private Long taskId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initiator_id")
    private Employee employee;
    private String comm;

    public Comment(Long taskId, Employee employee, String comm){
        this.taskId = taskId;
        this.employee = employee;
        this.comm = comm;
    }
}
