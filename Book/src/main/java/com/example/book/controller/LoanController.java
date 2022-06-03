package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.serivce.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {
    private final LoanService loanService;
    @GetMapping
    public ResponseEntity<List<Loan>> getLoan(){

        return ResponseEntity.status(200).body(loanService.getLoan());
    }
    @PostMapping
    public ResponseEntity addLoan(@RequestBody @Valid Loan loan, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }

        loanService.addLoan(loan);
        return ResponseEntity.status(200).body("Loan added");
    }
}
