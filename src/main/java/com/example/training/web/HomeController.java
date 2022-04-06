package com.example.training.web;

import com.example.training.dao.IPersonDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
@Slf4j
public class HomeController {

    @Autowired
    private IPersonDAO personDAO;

    /*@Value("${index.regards}")
    private String regards;*/

    @GetMapping("/")
    public String home(Model model){
        var persons = personDAO.findAll();
//        log.info("Run HomeController"); // RestController
//        return "Hello from Home"; // RestController
//        log.debug("More details about HomeController");
        model.addAttribute("persons", persons);
        return "index";
    }
}
