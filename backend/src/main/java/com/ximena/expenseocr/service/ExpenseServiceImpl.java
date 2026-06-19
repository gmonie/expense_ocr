package com.ximena.expenseocr.service;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;
import com.ximena.expenseocr.entity.Expense;
import com.ximena.expenseocr.exception.ExpenseNotFoundException;
import com.ximena.expenseocr.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;  


@Service
@RequiredArgsConstructor
/**
 * Clase que implementa la interfaz ExpenseService y 
 * proporciona la lógica de negocio para manejar los gastos.
 */
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    /**
     * Método que crea un nuevo gasto.
     * @param request que es el objeto que contiene los datos
     * necesarios para crear un nuevo gasto.
     * @return un objeto ExpenseResponse que contiene los datos 
     * del gasto creado.
     */
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

    /**
     * Método que obtiene todos los gastos.
     * @return una lista de objetos ExpenseResponse 
     * que contienen los datos.
     */
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

    /**
     * Método que obtiene un gasto por su ID.
     * @param id que es el ID del gasto a buscar.
     * @return un objeto ExpenseResponse que contiene 
     * los datos.
     */
    @Override
    public ExpenseResponse findById(UUID id){
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));

        return new ExpenseResponse(
            expense.getId(),
            expense.getStore(), 
            expense.getAmount(),
            expense.getPurchaseDate(),
            expense.getCategory()
        );
    }

    /**
     * Método que elimina un gasto por su ID.
     * @param id que es el ID del gasto a eliminar.
     */
    @Override 
    public  void delete(UUID id) {
       Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id)); 
       
        expenseRepository.delete(expense);
    }

    /**
     * Método que actualiza un gasto existente.
     * @param id que es el ID del gasto a actualizar.
     * @param request que es el objeto que contiene los datos.
     * @return un objeto ExpenseResponse que contiene los datos.
     */
    @Override
    public ExpenseResponse update(UUID id, ExpenseRequest request) {
        Expense expense = expenseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        expense.setStore(request.store());
        expense.setAmount(request.amount());
        expense.setPurchaseDate(request.purchaseDate());
        expense.setCategory(request.category());

        Expense updatedExpense = expenseRepository.save(expense);

        return new ExpenseResponse(
            updatedExpense.getId(),
            updatedExpense.getStore(),
            updatedExpense.getAmount(),
            updatedExpense.getPurchaseDate(),
            updatedExpense.getCategory()
        );
    }
}
