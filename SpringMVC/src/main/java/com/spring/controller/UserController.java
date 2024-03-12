package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller // он используется в MVC сервисах, где есть страницы
@RequestMapping("/user") // все методы этого контроллера начинаются с /user
public class UserController {

    @GetMapping("/hello") //HTTP GET
    public String helloPage() {
        boolean ok = new Random().nextBoolean();
        return ok ? "success" : "failure";
    }
}
