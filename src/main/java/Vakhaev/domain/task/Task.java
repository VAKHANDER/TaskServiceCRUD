package Vakhaev.domain.task;

import Vakhaev.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task")
@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "task_id_generator", sequenceName = "sq_task_id", allocationSize = 1)
    private Long id;

    private String name;
    private String priority;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initiator")
    private Employee initiator;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "approver")
    private Employee approver;
    private String status;
    private String description;

    public Task(String name, String priority, String status, String description){
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.description = description;
    }
}
