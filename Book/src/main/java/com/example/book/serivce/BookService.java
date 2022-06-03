package com.example.book.serivce;

import com.example.book.exception.InvalidIdException;
import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.model.User;
import com.example.book.repositry.BookRepository;
import com.example.book.repositry.LoanRepository;
import com.example.book.repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {

        bookRepository.save(book);
    }



    public void addLoanToUser(Integer userid, Integer bookId) {
        User user=userRepository.findById(userid).orElseThrow(()->new  InvalidIdException("User id is invalid"));
        Book book=bookRepository.findById(bookId).orElseThrow(()->new InvalidIdException("bookID is invalid"));
        Loan loan = new Loan(null, user.getId(), book.getId());
        loanRepository.save(loan);
        book.getLoans().add(loan);
        bookRepository.save(book);


    }
    public List<Loan> listOfLoan(Integer bookId){
        Book book=bookRepository.findById(bookId).orElseThrow(()->new InvalidIdException(" bookID is invalid"));

     return    loanRepository.findAllByBookId(book.getId());


    }
}
