package Vakhaev.adapter.rest.employee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Getter
public class SignUpDto{
    private String name;
    private String surname;
    private String lastName;
    private String login;
    private String password;
}
