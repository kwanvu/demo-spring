package web.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

}
