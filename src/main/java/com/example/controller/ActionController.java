package com.example.controller;

import com.example.dto.Action;
import com.example.exsaption.SaveValid;
import com.example.exsaption.UpdateValid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/action")
public class ActionController {
@PostMapping("/save")
    public ResponseEntity<Action> addUser(@Validated(SaveValid.class) @RequestBody Action action){

        return ResponseEntity.ok(action);
    }
@PutMapping("/update")
    public ResponseEntity<Action> updateUser(@Validated(UpdateValid.class) @RequestBody Action action){
    return ResponseEntity.ok(action);
    }
}
