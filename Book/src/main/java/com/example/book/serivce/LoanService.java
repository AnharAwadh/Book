package com.example.book.serivce;

import com.example.book.model.Loan;
import com.example.book.repositry.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;

    public List<Loan> getLoan() {
        return loanRepository.findAll();
    }

    public void addLoan(Loan loan) {
        loanRepository.save(loan);

    }
}
