package com.ximena.expenseocr.service;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;
import com.ximena.expenseocr.entity.Expense;    
import com.ximena.expenseocr.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;  


@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public ExpenseResponse create(ExpenseRequest request){

        Expense expense = Expense.builder() 
                .store(request.store()) 
                .amount(request.amount()) 
                .purchaseDate(request.purchaseDate()) 
                .category(request.category()) 
                .build();

        
        Expense savedExpense = expenseRepository.save(expense);

        return new ExpenseResponse(
                savedExpense.getId(),
                savedExpense.getStore(),
                savedExpense.getAmount(),
                savedExpense.getPurchaseDate(),
                savedExpense.getCategory()
        );
        
    }

    @Override
    public List<ExpenseResponse> findAll() {

        return expenseRepository.findAll().stream().map(expense -> new ExpenseResponse(
                expense.getId(),
                expense.getStore(),
                expense.getAmount(),
                expense.getPurchaseDate(),
                expense.getCategory()
        )).toList();
    }

    @Override
    public ExpenseResponse findById(UUID id){
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        return new ExpenseResponse(
            expense.getId(),
            expense.getStore(), 
            expense.getAmount(),
            expense.getPurchaseDate(),
            expense.getCategory()
        );
    }

    @Override 
    public  void delete(UUID id) {
        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found with id: " + id);
        }
        expenseRepository.deleteById(id);
    }
}
