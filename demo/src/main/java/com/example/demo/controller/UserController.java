package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get")
    public Page<User> getAllUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
            return userService.getAllUsers(page, size);
        }

        // @GetMapping("/{id}")
        // public ResponseEntity<User> getUserById(@PathVariable Long id) {
            //     return userService.getUserById(id)
            //     .map(ResponseEntity::ok)
            //     .orElse(ResponseEntity.notFound().build());
            // }

            @PostMapping("/user/add")
            public User createUser(@RequestBody User user) {
                return userService.createUser(user);
            }

            @PutMapping("/user/put/{id}")
            public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
                return ResponseEntity.ok(userService.updateUser(id, userDetails));
            }

            @DeleteMapping("/user/del/{id}")
            public String deleteUser(@PathVariable Long id) {
                userService.deleteUser(id);
                return "Successfull";
            }
            @GetMapping("/user/count")
            public int countAllUsers(){
                return userService.countAllUsers();
            }
        }