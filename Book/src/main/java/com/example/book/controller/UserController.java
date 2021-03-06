package com.example.book.controller;


import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.model.User;
import com.example.book.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUser(){

        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }

}
