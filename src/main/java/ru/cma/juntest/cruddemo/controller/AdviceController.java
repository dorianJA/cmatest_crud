package ru.cma.juntest.cruddemo.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> entityEmptyResult(RuntimeException e){
        return ResponseEntity.badRequest().body("Student with this id does not exist");
    }
}
