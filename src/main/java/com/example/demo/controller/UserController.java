package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.RegisterRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**

 Controller for managing users via REST API.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**

     Class constructor.
     @param userService service for working with users
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**

     Authorizes a user in the system.
     @param loginRequest data for user authorization
     @return ResponseEntity object with data about the user and HTTP status 200 (OK)
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        UserResponse userResponse = userService.login(loginRequest);
        return ResponseEntity.ok(userResponse);
    }

    /**

     Registers a new user in the system.
     @param registerRequest data for registering a new user
     @return ResponseEntity object with data about the user and HTTP status 200 (OK)
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        UserResponse userResponse = userService.register(registerRequest);
        return ResponseEntity.ok(userResponse);
    }

    /**

     Deletes a user from the system.
     @param userId user identifier
     @return ResponseEntity object with HTTP status 204 (NO CONTENT)
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}