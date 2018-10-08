package com.sprouts.springdemo.controller;

import com.sprouts.springdemo.beans.GenericResponse;
import com.sprouts.springdemo.beans.UserRequest;
import com.sprouts.springdemo.constants.ErrorType;
import com.sprouts.springdemo.data.User;
import com.sprouts.springdemo.exception.GenericError;
import com.sprouts.springdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "${frontend.proxy.url}")
@RestController
@RequestMapping(path = "${users.api.baseURI}")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserRequest.Builder userRequestBuilder) {
        User createdUser;
        try {
            createdUser = userRepository.save(userRequestBuilder.build().toUserData());
        } catch (PersistenceException e) {
            String errorMsg = "Unable to save user: " + userRequestBuilder;
            log.error(errorMsg, e);
            return ResponseEntity.unprocessableEntity().body(new GenericResponse(new GenericError(ErrorType.PROCESSING_ERROR, errorMsg)));
        }
        return ResponseEntity.ok(new GenericResponse("User created with Id: " + createdUser.getId()));
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
