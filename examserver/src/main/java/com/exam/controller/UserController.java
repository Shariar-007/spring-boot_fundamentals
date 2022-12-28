package com.exam.controller;

import com.exam.helper.UserNotFoundException;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception {
        Role role = new Role();
        role.setRoleName("NORMAL");
        role.setId(45L);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        User user1 = this.userService.createUser(user, userRoles);
        return user1;
    }

    @GetMapping
    public List<User> getAllUser() throws Exception {
        return this.userService.getAllUser();
    }

    @GetMapping("{userName}")
    public User getUser(@PathVariable("userName") String username) throws Exception {
        return this.userService.getUser(username);
    }

    @GetMapping("/userId/{userId}")
    public User getUserById(@PathVariable("userId") Long id) throws Exception {
        return this.userService.getUserById(id);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Long id) throws Exception {
        this.userService.deleteUser(id);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") Long id) throws Exception {
        User updatedUser = this.userService.updateUser(user, id);
        return updatedUser;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserNotFoundException ex) {
        return ResponseEntity.ok(ex);
    }

}
