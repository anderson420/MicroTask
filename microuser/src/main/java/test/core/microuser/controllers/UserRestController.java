package test.core.microuser.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import test.core.microuser.domain.User;
import test.core.microuser.services.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<?>> getAllUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        User userCreated = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User userUpdate = userService.updateUser(user);
        return ResponseEntity.ok(userUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
