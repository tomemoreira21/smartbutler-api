package com.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.SaldoService;

// recebe pedidos HTTP 
@RestController
@RequestMapping("/saldo")
public class SaldoController {
    private final SaldoService service;

    public SaldoService getService() {
        return service;
    }

    public SaldoController(SaldoService service) {
        this.service = service;
    }

    @GetMapping("/{utilizadorId}")
    public BigDecimal consultarSaldo(@PathVariable Integer id) {
        return service.saldo(id);
    }

}
