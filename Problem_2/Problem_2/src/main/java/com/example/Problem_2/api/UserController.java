package com.example.Problem_2.api;

import com.example.Problem_2.model.User;
import com.example.Problem_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Validated @NonNull @RequestBody User user){
        String email = user.getEmail();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()) {
            userService.addUser(user);
        }
//        String invaild = "Invalid Email Typed !!!"
//        userService.addUser(invaild);


        //user.getEmail()
        //userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return userService.getUserById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUser(id);

    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody User userToUpdate){
        userService.updateUser(id,userToUpdate);
    }
}
