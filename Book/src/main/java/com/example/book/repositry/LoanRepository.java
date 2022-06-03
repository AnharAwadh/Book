package com.example.book.repositry;

import com.example.book.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

    List<Loan> findAllByBookId(Integer bookId);
}
