package com.lucas.userdept.controllers;

import com.lucas.userdept.entities.User;
import com.lucas.userdept.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

   @Autowired
    private UserRepository repository;

   //End point para achar todos os usuários.
   @GetMapping
   public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    //End Point para encontrar os usuários por Id no Postman
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
       User result = repository.findById(id).get();
        return result;
    }

    //Salvar novo usuário no banco
    //No Postman, no new User, ir no body escolhendo as informações: raw e JSON.
    @PostMapping
    public User insert (@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }

}
