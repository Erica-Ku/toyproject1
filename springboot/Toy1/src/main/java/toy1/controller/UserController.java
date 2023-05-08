package toy1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toy1.domain.User;
import toy1.exception.EmailAlreadyExistsException;
import toy1.exception.InvalidLoginException;
import toy1.exception.UserNotFoundException;
import toy1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException e) {
            Map<String, String> error = new HashMap<>();
            error.put("email", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        try {
            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        try {
            userService.deleteUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        try {
            User user = userService.login(email, password);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (InvalidLoginException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}