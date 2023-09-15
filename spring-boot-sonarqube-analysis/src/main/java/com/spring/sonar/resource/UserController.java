package com.spring.sonar.resource;

import com.spring.sonar.dto.UserDto;
import com.spring.sonar.entity.User;
import com.spring.sonar.responsee.ApiResponse;
import com.spring.sonar.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/new/user")
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateExistingUser(@PathVariable("userId") int userId, @RequestBody User user) {

        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDto> getUserByUserId(@PathVariable("userId") int userId) {

        return new ResponseEntity<>(userService.findUserByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUserByUserId(@PathVariable("userId") int userId) {

        userService.deleteUserByUserId(userId);
        ApiResponse apiResponse = new ApiResponse("User deleted successfully", true);

        return new ResponseEntity<>(apiResponse, HttpStatus.GONE);
    }
}