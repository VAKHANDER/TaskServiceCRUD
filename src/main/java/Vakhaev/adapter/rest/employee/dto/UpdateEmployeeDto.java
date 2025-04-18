package Vakhaev.adapter.rest.employee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateEmployeeDto {
    private String name;
    private String surname;
    private String lastName;
    private String login;
}
