package com.ximena.expenseocr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Clase entidad que representa un gasto registrado por el usuario.
 */
@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    /*Identificador único del gasto.*/
    private UUID id;
    /*Nombre de la tienda donde se realizó el gasto.*/
    private String store;
    /*Cantidad total del gasto.*/
    private BigDecimal amount;
    /*Fecha en la que se realizó el gasto.*/
    private LocalDate purchaseDate;
    /*Categoría del gasto.*/
    private String category;
}
