package pl.sda.spring.thymeleafexample.domain.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StarterController {

    @GetMapping("/starter")
    public String viewStarter(final ModelMap modelMap) {
        modelMap.addAttribute("helloMsg", "WHATEVER");
        return "starter";
    }
}
