package com.ximena.expenseocr.controller;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;
import com.ximena.expenseocr.service.ExpenseService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor

public class ExpenseController {
    private final ExpenseService expenseService;

   @PostMapping 
   public ExpenseResponse create(
            @RequestBody ExpenseRequest request
    ){
         return expenseService.create(request);
    }

    @GetMapping
    public List<ExpenseResponse> findAll() {
        return expenseService.findAll();
    }

    @PutMapping("/{id}")
    public ExpenseResponse update(
        @PathVariable UUID id,
        @RequestBody ExpenseRequest request
    ) {
        return expenseService.update(id, request);
    }

    @GetMapping("/{id}") 
    public ExpenseResponse findById( 
        @PathVariable UUID id
    ) {
        return expenseService.findById(id);
     }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        expenseService.delete(id);
    }
    
}
