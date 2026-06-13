package com.ximena.expenseocr.controller;

import com.ximena.expenseocr.dto.ExpenseRequest;
import com.ximena.expenseocr.dto.ExpenseResponse;
import com.ximena.expenseocr.service.ExpenseService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor 

/**
    * Esta clase es la encargada de manejar las solicitudes HTTP que se
    * relacionan a los gastos, además de definir los endpoints para las
    * operaciones CRUD y utiliza ExpenseService para manejar la lógica
    * de negocio.
**/

public class ExpenseController {
    private final ExpenseService expenseService;

    /**
        * Método para crear un nuevo gasto.
        * @param request es un objeto que contiene los datos necesarios para crear un gasto. 
        * @return un objeto ExpenseResponse que representa el gasto creado.
    */
   @PostMapping 
   public ExpenseResponse create(
            @RequestBody ExpenseRequest request
    ){
         return expenseService.create(request);
    }

    /**
        * Método para obtener todos los gastos.
        * @return una lista de objetos ExpenseResponse que representan todos los gastos almacenados.
    */
    @GetMapping
    public List<ExpenseResponse> findAll() {
        return expenseService.findAll();
    }

    /**
     * Método para actualizar un gasto existente.
     * @param id identificador único del gasto a actualizar.
     * @param request objeto que contiene los datos necesarios 
     * para actualizar el gasto.
     * @return objeto de tipo ExpenseResponse que es el gasto actualizado.
     */
    @PutMapping("/{id}")
    public ExpenseResponse update(
        @PathVariable UUID id,
        @RequestBody ExpenseRequest request
    ) {
        return expenseService.update(id, request);
    }

    /**
     * Método para obtener un gasto por su ID.
     * @param id identificador único del gasto que se quiere buscar.
     * @return objeto de tipo ExpenseResponse que representa el gasto 
     * encontrado.
     * @throws ExpenseNotFoundException si no se encuentra un gasto con el ID proporcionado.
     */
    @GetMapping("/{id}") 
    public ExpenseResponse findById( 
        @PathVariable UUID id
    ) {
        return expenseService.findById(id);
     }

    
    /**
     * Método para eliminar un gasto por su ID.
     * @param id identificador único del gasto que se quiere eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        expenseService.delete(id);
    }
    
}
