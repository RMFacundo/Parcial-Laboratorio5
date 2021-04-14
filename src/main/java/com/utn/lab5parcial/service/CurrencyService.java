package com.utn.lab5parcial.service;

import com.utn.lab5parcial.model.Currency;
import com.utn.lab5parcial.model.Persona;
import com.utn.lab5parcial.repository.CurrencyRepository;
import com.utn.lab5parcial.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    public Currency getByID(Integer id) {
        return currencyRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    public void delete(Integer id){
        boolean exists = currencyRepository.existsById(id);
        if(!exists){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        currencyRepository.deleteById(id);
    }
}
