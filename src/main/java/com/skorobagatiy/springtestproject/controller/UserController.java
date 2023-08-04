package com.skorobagatiy.springtestproject.controller;

import com.skorobagatiy.springtestproject.model.User;
import com.skorobagatiy.springtestproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(UserController.USER_BASE_URL)
public class UserController {
    public static final String USER_BASE_URL = "/api/v1/user";

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createUser(@RequestBody User userBody) {
        logger.debug("POST /user");
        User user = userService.createUser(userBody);

        logger.info("User {} has been created.", user.getId());
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        logger.debug("GET /users, all users");
        List<User> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        logger.debug("GET /users/{}", id);
        User user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, UserDto userData) {
//        logger.debug("PUT /users/{}", id);
//        User user = userService.updateUser(id, userData);
//
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}
