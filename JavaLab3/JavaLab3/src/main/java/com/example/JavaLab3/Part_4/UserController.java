package com.example.JavaLab3.Part_4;

import com.example.JavaLab3.Part_1.P1_UserService;
import com.example.JavaLab3.Domain.User;
import com.example.JavaLab3.Domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/p1/user")
public class UserController {
    private final P1_UserService _P1_userService;

    @Autowired
    public UserController(P1_UserService p1UserService) {
        _P1_userService = p1UserService;
    }

    @GetMapping()
    public ResponseEntity<User> getUser(@RequestParam int id){
        var user = _P1_userService.findUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDto){
        var userId = _P1_userService.createUser(userDto);

        if(userId <0){
            return ResponseEntity.badRequest().build();
        }

        URI locationOfNewUser= UriComponentsBuilder
                .fromPath("user/{id}")
                .buildAndExpand(userId)
                .toUri();
        return ResponseEntity.created(locationOfNewUser).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO user, @PathVariable int id){
       try{
           _P1_userService.updateUser(user, id);
       } catch (Exception e){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        if(_P1_userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
