package com.ximena.expenseocr.repository;

import com.ximena.expenseocr.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository
        extends JpaRepository<Expense, UUID> {
}
