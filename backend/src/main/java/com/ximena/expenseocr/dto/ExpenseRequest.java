package com.ximena.expenseocr.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO para crear un nuevo gasto. 
 * @param store que es el nombre de la tienda dond se realizó
 * el gasto.
 * @param amount que es el monto del gasto.
 * @param purchaseDate que es la fecha en la que se realizó 
 * el gasto.
 * @param category que es la categoría del gasto.
 */
public record ExpenseRequest(String store,
                            BigDecimal amount,
                            LocalDate purchaseDate,
                            String category
) {}
