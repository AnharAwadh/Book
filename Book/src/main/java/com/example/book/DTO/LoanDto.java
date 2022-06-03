package com.example.book.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class LoanDto {


    private Integer userId;
    private Integer bookId;
}
