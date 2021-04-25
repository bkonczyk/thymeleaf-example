package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    List<Employee> getAll() {
        return repository.findAll();
    }

    void addEmployee(Employee employee) {
        repository.save(employee);
    }
}
