package com.utn.lab5parcial.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@JsonTypeName("jugador")
public class Jugador extends Persona {
    @NotNull
    private Float peso;
    @NotNull
    private Float altura;
    @NotNull
    private Float minutosJugados;
    @NotNull
    private Date FechaDeNacimiento;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency currency;
}
