package com.utn.lab5parcial.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jugador.class, name = "jugador"),
        @JsonSubTypes.Type(value = Representante.class, name = "representante")
})
public abstract class Persona {

    @Id
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;
}