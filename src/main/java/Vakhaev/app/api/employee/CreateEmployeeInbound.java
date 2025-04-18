package Vakhaev.app.api.employee;

public interface CreateEmployeeInbound {
    String execute(String name, String surname, String lastName, String login, String password);
}
