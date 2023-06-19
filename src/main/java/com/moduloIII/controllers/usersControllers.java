package com.moduloIII.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.moduloIII.Repository.usersRepository;
import com.moduloIII.collections.Users;
import com.moduloIII.service.UsersService;

@RestController
@RequestMapping("mongo/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class usersControllers {

    @Autowired
    private UsersService usersService;
    
    @Autowired
    usersRepository usersRepository;

    @PostMapping("/register")
    public Users saveUser(@RequestBody  Users user) {
    	  return usersService.create(user);
      
    }

   


    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAll();
    }

    @PostMapping("/delete")
    public String deleteUserByEmail(@RequestParam("userEmail") String userEmail) {
        usersService.deleteUserByEmail(userEmail);
        return "redirect:/mongo/users/all";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Users user) {
        boolean authenticated = usersService.authenticate(user.getEmail(), user.getPassword());
        if (authenticated) {
            return "redirect:/mongo/pc";
        } else {
            return "login";
        }
    }
    
    @PutMapping("/update/{userEmail}")
    public Users updateUser(@PathVariable("userEmail") String userEmail, @RequestBody Users updatedUser) {
        return usersService.updateUser(userEmail, updatedUser);
    }
    
    @GetMapping("/{userEmail}")
    public Users getUserByEmail(String userEmail) {
        return usersRepository.findByEmail(userEmail);
    }


}
