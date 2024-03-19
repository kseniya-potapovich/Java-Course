package com.spring.controller;

import com.spring.model.User;
import com.spring.model.dto.UserCreateDto;
import com.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    public String getUserById(@PathVariable Long id, ModelMap modelMap) { //@PathVariable - если мы хотим достать из пути
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            modelMap.addAttribute("user", user.get());
            return "get_user_by_id";
        }
        return "empty";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id) ? "success" : "failure";
    }

    @PostMapping
    public String createUser(@ModelAttribute @Valid UserCreateDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.toString());
            }
            return "failure";
        }
        return userService.createUser(user) ? "success" : "failure";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("username") String username,
                             @RequestParam("userPassword") String userPassword,
                             @RequestParam("age") Integer age) {
        return userService.updateUser(id, username, userPassword, age) ? "success" : "failure";
    }
}
