package com.ximena.expenseocr.exception;

import java.util.UUID;

/**
 * Excepción personalizada que nos indica que un gasto no
 * fue encontrado.
 */

public class ExpenseNotFoundException extends RuntimeException {
    
    public ExpenseNotFoundException(UUID id) {
        super("Expense not found with id: " + id);
    }
    
}
