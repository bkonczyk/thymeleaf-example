package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.Value;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Value
public class CreateEmployeeRequest {

    @NotEmpty(message = "Name cannot be empty")
    String name;
    @NotEmpty(message = "Surname cannot be empty")
    String surname;
    @Email(message = "Invalid email")
    String email;
    @PESEL(message = "Invalid pesel")
    String pesel;
    @Min(value = 0, message = "Age must be at least 0")
    @Max(value = 150, message = "I don't think so")
    Integer age;
}
