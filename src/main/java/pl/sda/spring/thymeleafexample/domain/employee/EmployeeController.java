package pl.sda.spring.thymeleafexample.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/")
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
        return "new-employee";
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = service.getOne(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
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
        return "paginated-index";
    }
}
