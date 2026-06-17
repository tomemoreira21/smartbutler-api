package com.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CriarTransacaoDTO;
import com.entities.Transacao;
import com.services.TransacaoService;

// recebe pedidos HTTP 
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    // 1 - Todas as transações de um utilizador
    // GET localhost:8080/transacoes/utilizador/1
    @GetMapping("/utilizador/{id}")
    public List<Transacao> listar (@PathVariable Integer id) {
        return service.listarTransacoesUtilizador(id);
    }

    // 2 - Total gasto pelo utilizador
    // GET localhost:8080/transacoes/total/1
    @GetMapping("/total/{id}")
    public BigDecimal total(@PathVariable Integer id) {
        return service.calcularTotalGasto(id);
    }

    // 3 - Gastos agrupados por categoria
    // GET localhost:8080/transacoes/categorias/1
    @GetMapping("/categorias/{id}")
    public List<Object[]> gastosCategoria(
            @PathVariable Integer id
    ) {

        return service.gastosCategoria(id);
    }

    // 4 - Últimas 10 transações
    // GET localhost:8080/transacoes/ultimas/1
    @GetMapping("/ultimas/{id}")
    public List<Transacao> ultimas10transacoes(
            @PathVariable Integer id
    ) {

        return service.ultimasTransacoes(id);
    }

    // 5 - Gastos entre datas
    // GET localhost:8080/transacoes/periodo/1?inicio=2026-01-01&fim=2026-06-16
    @GetMapping("/periodo/{id}")
    public BigDecimal periodo(
            @PathVariable Integer id,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim
    ) {

        return service.gastoEntreDatas(
                id,
                inicio,
                fim
        );
    }

    // Criacao de Transacao
    @PostMapping
    public Transacao criar(@RequestBody CriarTransacaoDTO dto) {
        return service.criar(dto);
    }
    

}
