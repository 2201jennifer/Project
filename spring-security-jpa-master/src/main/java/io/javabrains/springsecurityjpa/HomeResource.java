package io.javabrains.springsecurityjpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeResource {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello from the Home Page");
        return "home";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("message", "Hello from the User Page");
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("message", "Hello from the Admin Page");
        return "admin";
    }
}
