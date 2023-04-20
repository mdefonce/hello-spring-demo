package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String greeting = HelloController.createMessage(name, language);
        return "<h3 style='color:green'>" + greeting + "</h3>";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                "    <option value='English'>English</option>" +
                "    <option value='German'>German</option>" +
                "    <option value='Spanish'>Spanish</option>" +
                "    <option value='French'>French</option>" +
                "    <option value='Klingon'>Klingon</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        if (language.contains("German")) {return "Hallo, " + name + "!";}
        else if (language.contains("French")) {return "Bonjour, " + name + "!";}
        else if (language.contains("Spanish")) {return "Hola, " + name + "!";}
        else if (language.contains("Klingon")) {return "nuqneH, " + name + "!";}
        else {return "Hello, " + name + "!";}
    }

}
