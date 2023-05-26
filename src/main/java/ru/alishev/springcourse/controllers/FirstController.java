package ru.alishev.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

  @GetMapping("/hello")
  public String helloPage(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam("surname") String surname,
      Model model) {

    model.addAttribute("message", "Hello, " + name + " " + surname);

    return "first/hello";
  }

  @GetMapping("/goodbye")
  public String goodbyePage() {
    return "first/goodbye";
  }

  @GetMapping("/calc")
  public String calc(
      @RequestParam("a") Integer a,
      @RequestParam("b") Integer b,
      @RequestParam("action") String action,
      Model model) {

    model.addAttribute("action", action);
    model.addAttribute("a", a);
    model.addAttribute("b", b);

    System.out.println("action :>> " + action);
    System.out.println(action instanceof String);

    System.out.println(action == "multiplication");

    Double res = null;

    if (action.equals("multiplication")) {
      res = (double) a * b;
    }

    if (action.equals("addition")) {
      res = (double) a + b;
    }

    if (action.equals("subtraction")) {
      res = (double) a - b;
    }

    if (action.equals("division")) {
      res = (double) a / b;
    }

    model.addAttribute("result", res);

    return "first/calc";
  }
}
