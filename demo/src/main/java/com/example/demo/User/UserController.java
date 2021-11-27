package com.example.demo.User;

import com.example.demo.Admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="user")
public class UserController {
    private final UserServies userServies;
    @Autowired
    public UserController(UserServies userServies) {
        this.userServies = userServies;
    }


    @GetMapping
    private List<User> getUsers ()
    {
        return userServies.getUsers ();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userServies.getUser(id);

    }
    @PostMapping
    public  User createUser(@RequestBody  User  user){
        return  userServies. createUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userServies.deleteUser(id);

    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User data)
    {
        userServies. updateUser(id,data);
    }
}


