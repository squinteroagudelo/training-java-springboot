package com.example.training.web;

import com.example.training.domain.Person;
import com.example.training.service.PersonServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

//@RestController
@Controller
@Slf4j
public class HomeController {

    @Autowired
    private PersonServiceImp personService;

    /*@Value("${index.regards}")
    private String regards;*/

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user){
        var persons = personService.getPersons();
//        log.info("Run HomeController"); // RestController
//        return "Hello from Home"; // RestController
//        log.debug("More details about HomeController");
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping("/add")
    public String add(Person person){
        return "save";
    }

    @PostMapping("/create")
    public String create(@Valid Person person, Errors errors){
        if (errors.hasErrors())
            return "save";
        personService.createPerson(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{id_person}")
    public String edit(Person person, Model model){
        person = personService.getPerson(person);
        model.addAttribute("person", person);
        return "save";
    }

    @GetMapping("/delete")
    public String delete(Person person){
        personService.deletePerson(person);
        return "redirect:/";
    }
}
