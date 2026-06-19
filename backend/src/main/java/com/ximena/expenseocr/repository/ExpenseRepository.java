package com.ximena.expenseocr.repository;

import com.ximena.expenseocr.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * Interface para el repositorio de gastos,
 * extiende JpaRepository que nos da operaciones CRUD
 * para las entidades de tipo expense.
 */
public interface ExpenseRepository
        extends JpaRepository<Expense, UUID> {
}
