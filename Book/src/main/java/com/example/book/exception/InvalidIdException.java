package com.example.book.exception;

public class InvalidIdException extends  RuntimeException{

    public InvalidIdException(String massage){

        super(massage);
    }

}

