package com.utn.lab5parcial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Currency {

    enum CURRENCY {
        EURO,
        DOLAR,
        PESO
    }

    @Id
    private Integer id;

    @NotNull
    private CURRENCY currency;

    @NotNull
    private Float monto;

}
