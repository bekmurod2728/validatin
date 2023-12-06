package com.example.controller;

import com.example.dto.Action;
import com.example.dto.Role;
import com.example.dto.User;
import com.example.exeptin.MyBadRequestExaption;
import com.example.exsaption.UpdateValid;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
@PostMapping("/save")
    public ResponseEntity<Role> addUser(@RequestBody Role role){
    ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    Validator validator=factory.getValidator();
    Set<ConstraintViolation<Role>> validate1 = validator.validate(role);
    if (!validate1.isEmpty()) {
        List<String> collect = validate1.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        throw new MyBadRequestExaption(collect.toString());
    }

    for (User user : role.getUsers()) {
        Set<ConstraintViolation<Role>> validate = validator.validate(role);
        if (!validate.isEmpty()) {
            List<String> collect3 = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new MyBadRequestExaption(collect3.toString());
        }
    }
    for (Action action : role.getActions()) {
        Set<ConstraintViolation<Action>> validate = validator.validate(action);
        if (!validate.isEmpty()) {
            List<String> collect2 = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new MyBadRequestExaption(collect2.toString());
        }
    }
        return ResponseEntity.ok(role);
    }
@PutMapping("/update")
    public ResponseEntity<Role> updateUser(@RequestBody Role role){
    ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    Validator validator=factory.getValidator();
    Set<ConstraintViolation<Role>> validate = validator.validate(role, UpdateValid.class);
    for (ConstraintViolation<Role> constraint : validate) {
        throw new MyBadRequestExaption(constraint.getMessage());
    }

    return ResponseEntity.ok(role);
    }
}
