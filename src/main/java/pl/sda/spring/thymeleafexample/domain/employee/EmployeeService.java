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

    Employee getOne(Long id) {
        return repository.findById(id).orElse(new Employee());
    }

    void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
