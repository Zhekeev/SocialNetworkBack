package qz.reactjava.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qz.reactjava.project.model.User;
import qz.reactjava.project.model.dto.UserDto;
import qz.reactjava.project.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/users/")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/all/{page}")
    private ResponseEntity<List<UserDto>> getAllUser(@PathVariable(name = "page")int page){
        Page<User> users = userServiceImpl.allUsersWithPageParameter(page);
        List<UserDto> result = new ArrayList<>();
        users.forEach(user -> result.add(UserDto.fromUser(user)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    private ResponseEntity<List<User>> getAllUserWithoutPageable(){
        List<User> result = userServiceImpl.getAllUser();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity addUser(@RequestBody User user, Long id){
        userServiceImpl.save(user, id);
        Map<Object, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    private ResponseEntity<User> update(@RequestBody User user){
        User updatedUser = userServiceImpl.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping
    private ResponseEntity delete(@RequestBody User user){
        userServiceImpl.delete(user);
        Map<Object, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
