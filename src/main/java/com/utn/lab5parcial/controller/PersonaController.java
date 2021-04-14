package com.utn.lab5parcial.controller;

import com.utn.lab5parcial.model.Persona;
import com.utn.lab5parcial.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonaController {

    PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @PostMapping
    public void addPersona(@RequestBody Persona persona) {
        personaService.add(persona);
    }

    @GetMapping
    public List<Persona> getAll(){
        return personaService.getAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Integer id) {
        return personaService.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id){
        personaService.delete(id);
    }

    @PutMapping("/person/{id}/jugadores/{idJugador}")
    public void updatePersona(@PathVariable("id") Integer idPersona, @PathVariable("idJugador") Integer idJugador) {
        personaService.update(idPersona, idJugador);

    }
}
