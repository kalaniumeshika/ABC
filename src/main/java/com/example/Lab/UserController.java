package com.example.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            // Check if the provided ID already exists
            if (userRepository.existsById(user.getId())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with provided ID already exists.");
            }

            // Save the user
            userRepository.save(user);

            // Return success response
            return ResponseEntity.ok("User added successfully.");
        } catch (Exception e) {
            // If there is an error while adding the user, return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user.");
        }
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            // Fetch all users from the database
            List<User> users = userRepository.findAll();

            // Return the list of users as a response
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            // If there is an error while fetching users, return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
