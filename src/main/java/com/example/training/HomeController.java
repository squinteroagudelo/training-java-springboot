package com.example.training;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

//@RestController
@Controller
@Slf4j
public class HomeController {

    @Value("${index.regards}")
    private String regards;

    @GetMapping("/")
    public String home(Model model){
//        log.info("Run HomeController"); // RestController
//        return "Hello from Home"; // RestController
//        log.debug("More details about HomeController");
        var greet = "Hello from Home";
        var person = new Person();
        person.setName("Samuel");
        person.setLastname("Quintero");
        person.setEmail("squintero@gmail.com");
        person.setPhone("3207101960");

        var otherPerson = new Person();
        otherPerson.setName("Ricardo");
        otherPerson.setLastname("Agudelo");
        otherPerson.setEmail("ragudelo@gmail.com");
        otherPerson.setPhone("3174587620");

        /*var persons = new ArrayList<Person>();
        persons.add(person);
        persons.add(otherPerson);*/

        var persons = Arrays.asList(person, otherPerson);

        model.addAttribute("greet", greet);
        model.addAttribute("regards", regards);
        model.addAttribute("persons", persons);
        return "index";
    }
}
