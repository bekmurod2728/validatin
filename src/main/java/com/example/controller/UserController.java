package com.example.controller;

import com.example.dto.Role;
import com.example.dto.User;
import com.example.exeptin.MyBadRequestExaption;
import com.example.exsaption.SaveValid;
import com.example.exsaption.UpdateValid;
import jakarta.validation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
@PostMapping("/save")
    public ResponseEntity<User> addUser(@RequestBody User user){
    ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    Validator validator=factory.getValidator();
    Set<ConstraintViolation<User>> validate1 = validator.validate(user, SaveValid.class);
    if (!validate1.isEmpty()) {
        List<String> collect = validate1.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        throw new MyBadRequestExaption(collect.toString());
    }

    for (Role role : user.getRoles()) {
        Set<ConstraintViolation<Role>> validate = validator.validate(role,SaveValid.class);
        if (!validate.isEmpty()) {
            List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new MyBadRequestExaption(collect.toString());
        }
    }
        return ResponseEntity.ok(user);
    }
@PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
    ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    Validator validator=factory.getValidator();
    Set<ConstraintViolation<User>> validate = validator.validate(user, UpdateValid.class);
    for (ConstraintViolation<User> constraint : validate) {
        throw new MyBadRequestExaption(constraint.getMessage());
    }

    return ResponseEntity.ok(user);
    }
}
