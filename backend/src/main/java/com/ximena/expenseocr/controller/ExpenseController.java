package com.ximena.expenseocr.controller;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;
import com.ximena.expenseocr.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
