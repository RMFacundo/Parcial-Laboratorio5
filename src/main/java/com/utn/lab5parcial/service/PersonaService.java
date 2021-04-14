package com.utn.lab5parcial.service;

import com.utn.lab5parcial.model.Persona;
import com.utn.lab5parcial.model.Representante;
import com.utn.lab5parcial.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Persona getByID(Integer id) {
        return personaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void add(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(Integer id){
        boolean exists = personaRepository.existsById(id);
        if(!exists){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        personaRepository.deleteById(id);
    }

    public void update(Integer idPersona, Integer idJugador){
    }
}
