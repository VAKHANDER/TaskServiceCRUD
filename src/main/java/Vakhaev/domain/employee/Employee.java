package Vakhaev.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "employee_id_generator", sequenceName = "sq_employee_id", allocationSize = 1)
    private Long id;

    private String name;
    private String surname;

    @Column(name = "last_name")
    private String lastName;
    private String login;
    @JsonIgnore
    private String password;

    public Employee(String name, String surname, String lastName, String login, String password){
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }
}
