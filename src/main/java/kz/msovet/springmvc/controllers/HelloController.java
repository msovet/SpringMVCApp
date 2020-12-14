package kz.msovet.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Merey Sovet
 */

@Controller
public class HelloController {
    @GetMapping("/start")
    public String start(@RequestParam("name") String name,
                        @RequestParam(value = "surname", required = false) String surname,
                        Model model){
        // System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello," + name + " " + surname);
        return "hello/start";
    }
    @GetMapping("/finish")
    public String finish() {
        return "hello/finish";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        double result=0;
        if (action.equals("add")) {
            result = a + b;
        }
        else if (action.equals("subtr")) {
            result = a - b;
        }
        else if(action.equals("mult")) {
            result = a*b;
        }
        else if(action.equals("div")) {
            result = a/(double)b;
        }
        model.addAttribute("result","Result is: " + result);
        return "calc/calc";
    }
}
