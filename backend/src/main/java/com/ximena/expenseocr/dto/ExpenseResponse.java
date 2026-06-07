package com.ximena.expenseocr.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpenseResponse(UUID id,
                            String store,
                            BigDecimal amount,
                            LocalDate purchaseDate,
                            String category
) {}
