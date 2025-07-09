package com.epam.feign;

import com.epam.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/users")
    List<User> getAllUsers();

    @GetMapping("/users/{username}")
    User getUserByUsername(@PathVariable String username);

    @PostMapping("/users")
    User saveUser(@RequestBody User user);

    @PutMapping("/users/{username}")
    User updateUser(@PathVariable String username, @RequestBody User user);

    @DeleteMapping("/users/{username}")
    void deleteUser(@PathVariable String username);
}
