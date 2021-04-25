package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.Value;

@Value
public class CreateEmployeeRequest {

    String name;
    String surname;
    String email;
    String pesel;
    Integer age;
}
