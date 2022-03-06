package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import no.kebabproffen.models.User;
import no.kebabproffen.repositories.*;

@RestController
@RequestMapping("/api/users")
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  List<User> all() {
    return repository.findAll();
  }


  @PostMapping("/")
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  @GetMapping("/{userId}")
  User one(@PathVariable("userId") UUID userId) {
    return repository.findById(userId)
    .orElseGet(() -> null);
  }

  @DeleteMapping("/{userId}")
  void deleteUser(@PathVariable("userId") UUID userid){
    repository.deleteById(userid);
  }


}