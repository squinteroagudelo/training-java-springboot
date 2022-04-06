package com.example.training.web;

import com.example.training.dao.IPersonDAO;
import com.example.training.service.PersonServiceImp;
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
    private PersonServiceImp personService;

    /*@Value("${index.regards}")
    private String regards;*/

    @GetMapping("/")
    public String home(Model model){
        var persons = personService.getPersons();
//        log.info("Run HomeController"); // RestController
//        return "Hello from Home"; // RestController
//        log.debug("More details about HomeController");
        model.addAttribute("persons", persons);
        return "index";
    }
}
