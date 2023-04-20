package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value="hello")
public class HelloController {

    // responds to /hello
    @GetMapping("")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    // responds to /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String helloGoodbye() {
        return "Hello, Goodbye";
    }

//    @GetMapping("hello")
////    @GetMapping
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // responds to post requests at "/goodbye"
//    @PostMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

    // responds to get and post requests at "/hellogoodbye"
//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
//    public String hellogoodbye() {
//        return "HelloGoodbye, Spring!";
//    }

    // Responds to get requests at /hello?coder=LaunchCoder
//    @GetMapping("hello")
//    @ResponseBody
//    public String helloQueryParam(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }

//    @GetMapping("hello/{coder}")
//    @ResponseBody
//    public String helloPathParam(@PathVariable String coder) {
//        return "Hello, " + coder + "!";
//    }

    @GetMapping("{name}")
    public String helloPathRedirect(@PathVariable String name) {
        return "redirect:/" + name;
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'coder' />" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }


}
