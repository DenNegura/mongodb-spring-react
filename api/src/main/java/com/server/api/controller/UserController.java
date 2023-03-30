package com.server.api.controller;

import com.server.api.domain.User;
import com.server.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    private ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable String id) {
        userRepository.deleteById(id);
    }

    @PostMapping
    private ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}
