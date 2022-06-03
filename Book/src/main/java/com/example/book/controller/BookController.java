package com.example.book.controller;

import com.example.book.DTO.LoanDto;
import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.serivce.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    Logger logger= LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBook(){
        logger.info("Call GetBook ");

        return ResponseEntity.status(200).body(bookService.getBook());
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody@Valid Book book){
        logger.info("Call AddBook ");

        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added");
    }


    @PostMapping("addloantouser/{userid}/{bookid}")
    public ResponseEntity addBookToUser(@PathVariable Integer userid, @PathVariable Integer bookid ){
        logger.info("Call  addBookToUser ");

        bookService.addLoanToUser(userid,bookid);

        return ResponseEntity.status(200).body("book loan");
    }

    @PostMapping("listloan/{bookid}")
    public ResponseEntity<List<Loan>> listOfLoan(@PathVariable Integer bookid){


        return ResponseEntity.status(200).body( bookService.listOfLoan(bookid));
    }


}
