package main.controller;

import main.api.response.InitResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    private final InitResponse initResponse;

    public DefaultController(InitResponse initResponse) {
        this.initResponse = initResponse;
    }

    @RequestMapping("/")
    public String getStartedPage(){
        return "index";
    }
}
