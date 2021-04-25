package pl.sda.spring.thymeleafexample.domain.employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    Employee fromRequest(CreateEmployeeRequest request) {
        return new Employee()
            .setName(request.getName())
            .setSurname(request.getSurname())
            .setEmail(request.getEmail())
            .setPesel(request.getPesel())
            .setAge(request.getAge());
    }
}
