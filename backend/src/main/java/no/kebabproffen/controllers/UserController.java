package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.UserDAO;
import no.kebabproffen.models.DTO.UserDTO;
import no.kebabproffen.repositories.*;

@RestController
@RequestMapping("/api/users")
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  List<UserDTO> all() {
    return repository.findAll().stream().map(UserDAO::toDTO).toList();
  }


  @PostMapping("/")
  UserDTO newUser(@RequestBody UserDTO newUser) {
    System.out.println(newUser.getRole().getRole());
    return repository.save(newUser.toDAO()).toDTO();
  }

  @GetMapping("/{userId}")
  UserDTO one(@PathVariable("userId") UUID userId) {
    return repository.findById(userId).get().toDTO();
  }

  @DeleteMapping("/{userId}")
  void deleteUser(@PathVariable("userId") UUID userid){
    repository.deleteById(userid);
  }


}