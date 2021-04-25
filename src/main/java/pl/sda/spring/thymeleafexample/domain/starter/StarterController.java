package pl.sda.spring.thymeleafexample.domain.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StarterController {

    @GetMapping("/starter/{name}")
    public String viewStarter(@PathVariable String name, final Model model) {
        model
            .addAttribute("name", name)
            .addAttribute("helloMsg", "Hello");
        return "starter";
    }

//        @GetMapping("/starter/{name}")
//    public String viewStarter(@PathVariable String name, final ModelMap modelMap) {
//        modelMap
//            .addAttribute("name", name)
//            .addAttribute("helloMsg", "Hello");
//        return "starter";
//    }
}
