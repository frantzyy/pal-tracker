package io.pivotal.pal.tracker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {

        return "hello";
    }

    @GetMapping("/surf")
    public String getSurf() {

        return "surfs up!!!!";
    }

}
