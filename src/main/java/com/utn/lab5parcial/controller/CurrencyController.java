package com.utn.lab5parcial.controller;

import com.utn.lab5parcial.model.Currency;
import com.utn.lab5parcial.model.Persona;
import com.utn.lab5parcial.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @PostMapping
    public void addCurrency(@RequestBody Currency currency) {
        currencyService.add(currency);
    }

    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id) {
        return currencyService.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Integer id){
        currencyService.delete(id);
    }

}
