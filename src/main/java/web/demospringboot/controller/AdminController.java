package web.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.demospringboot.repository.BookRepository;

@Controller
@Transactional
public class AdminController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/admin/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model){
        return "adminDashboard";
    }

    @GetMapping(value = "/admin/dashboard")
    public String dashboard(Model model){
        return "adminDashboard";
    }

    @GetMapping(value = "/admin/product")
    public String product(Model model){
        return "adminProduct";
    }

    @GetMapping(value = "/admin/user")
    public String user(Model model){
        return "adminUser";
    }

    @GetMapping(value = "/admin/product/create")
    public String createProduct(Model model){
        return "adminCreateProduct";
    }

}
