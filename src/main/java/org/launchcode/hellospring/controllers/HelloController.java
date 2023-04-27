package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
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

//    @GetMapping("{name}")
//    @ResponseBody
//    public String helloPathRedirect(@PathVariable String name) {
//        return "redirect:/" + name;
//    }


    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder, Model model) {
        String theGreeting = "Hello, " + coder + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloPathRedirect(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LC");
        names.add("Marcie");
        names.add("Java");
        model.addAttribute("names", names);
        return "hello-list";
    }


}
