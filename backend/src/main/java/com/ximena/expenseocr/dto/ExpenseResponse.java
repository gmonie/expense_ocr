package com.ximena.expenseocr.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO que regresa la información del gasto.
 */
public record ExpenseResponse(
    /** El identificador único del gasto. */
    UUID id,
    /** El nombre de la tienda donde se realizó la compra. */
    String store,
    /** El monto total del gasto. */
    BigDecimal amount,
    /** La fecha en que se realizó la compra. */
    LocalDate purchaseDate,
    /** La categoría del gasto. */
    String category
) {}