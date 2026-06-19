package com.ximena.expenseocr.service;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;

import java.util.List;
import java.util.UUID;

/**
 * Interfaz que define los métodos del servicio de gastos. 
 */
public interface ExpenseService {

    ExpenseResponse create(ExpenseRequest request);

    List<ExpenseResponse> findAll();

    ExpenseResponse findById(UUID id);

    void delete(UUID id);

    ExpenseResponse update(UUID id,ExpenseRequest request);
}
