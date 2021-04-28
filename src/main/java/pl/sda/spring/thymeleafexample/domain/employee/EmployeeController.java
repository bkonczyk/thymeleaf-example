package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public String empty() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String viewAllEmployees(Model model) {
        return findPaginated(1, model);

//        INITIAL SOLUTION BELOW
//        List<Employee> employees = service.getAll();
//        model.addAttribute("employees", employees);
//        return "index";
    }

    @GetMapping("/add-employee-form")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        service.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = service.getOne(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/update-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-employee";
        }
        service.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/index";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable int pageNo, Model model) {
        int pageSize = 5;

        Page<Employee> page = service.findPaginated(pageNo, pageSize);
        List<Employee> employees = page.getContent();

        model.addAttribute("employees", employees);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        return "index";
    }
}
