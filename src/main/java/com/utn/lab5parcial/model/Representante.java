package com.utn.lab5parcial.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonTypeName("representante")
public class Representante extends Persona{

    private Float pesoBoveda;
    private Float montoTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    List<Jugador> jugadorList;

    public Representante(){
        pesoBoveda = calcularPesoBoveda();
        montoTotal = calcularMontoTotal();
    }

    private Float calcularMontoTotal() {
        Float montoTotal = 0.0f;
        for(Jugador j: jugadorList){
            if(j.getCurrency().getCurrency().equals(Currency.CURRENCY.EURO)){
                montoTotal += (j.getCurrency().getMonto()*111.00f);
            }
            else if(j.getCurrency().getCurrency().equals(Currency.CURRENCY.DOLAR)){
                montoTotal += (j.getCurrency().getMonto()*92.00f);
            }
            else{
                montoTotal += j.getCurrency().getMonto();
            }
        }
        return montoTotal;
    }

    public Float calcularPesoBoveda(){
        Float pesoBoveda = 0.0f;
        for(Jugador j: jugadorList){
            pesoBoveda += j.getCurrency().getMonto();
        }
        return pesoBoveda;
    }
}
