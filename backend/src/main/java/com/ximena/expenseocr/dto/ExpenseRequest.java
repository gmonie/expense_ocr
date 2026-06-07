package com.ximena.expenseocr.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(String store,
                            BigDecimal amount,
                            LocalDate purchaseDate,
                            String category
) {}
