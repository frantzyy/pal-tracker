package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    private String message;


    public WelcomeController( @Value("${welcome.message}") String inputMessage){

        message = inputMessage;
    }


    @GetMapping("/")
    public String sayHello() {

        return message;
    }

    @GetMapping("/surf")
    public String getSurf() {

        return "surfs up!!!!";
    }

}
