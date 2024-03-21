package com.spring.controller;

import com.spring.exceptions.CustomValidException;
import com.spring.model.User;
import com.spring.model.dto.UserCreateDto;
import com.spring.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller // он используется в MVC сервисах, где есть страницы
@RequestMapping("/user") // все методы этого контроллера начинаются с /user
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        List<User> users = userService.getAllUsers();
        modelAndView.setViewName(users.isEmpty() ? "empty" : "get_users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, ModelMap modelMap, HttpServletResponse httpServletResponse) { //@PathVariable - если мы хотим достать из пути
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            modelMap.addAttribute("user", user.get());
            httpServletResponse.setStatus(200);
            return "get_user_by_id";
        }
        httpServletResponse.setStatus(404);
        return "empty";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable Long id, HttpServletResponse response) {
        if (userService.deleteUser(id)) {
            response.setStatus(204);
            return "success";
        } else {
            response.setStatus(409);
            return "failure";
        }
    }

    @PostMapping
    public String createUser(@ModelAttribute @Valid UserCreateDto user, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidException(bindingResult.getAllErrors().toString());
        }
        if (userService.createUser(user)) {
            response.setStatus(201);
            return "success";
        } else {
            response.setStatus(409);
            return "failure";
        }
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("username") String username,
                             @RequestParam("userPassword") String userPassword,
                             @RequestParam("age") Integer age,
                             HttpServletResponse response) {
        if (userService.updateUser(id, username, userPassword, age)) {
            response.setStatus(204);
            return "success";
        } else {
            response.setStatus(409);
            return "failure";
        }
    }

    @ExceptionHandler(CustomValidException.class)
    public ModelAndView customValidExceptionHandler(Exception exception, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", exception);
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("failure");
        modelAndView.setStatus(HttpStatusCode.valueOf(400));
        System.out.println(exception);
        return modelAndView;
    }
}
