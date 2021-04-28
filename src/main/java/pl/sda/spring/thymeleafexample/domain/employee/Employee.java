package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    private String surname;
    private String email;
    private String pesel;
    private Integer age;
}
