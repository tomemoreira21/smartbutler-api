package com.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.Transacao;
import com.repositories.TransacaoRepository;


@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository){
        this.repository = repository;
    }


    public List<Transacao> listarTransacoesUtilizador(Integer id){

        return repository.findByUtilizador(id);

    }


    public BigDecimal calcularTotalGasto(Integer id){

        BigDecimal total = repository.totalGasto(id);

        if(total == null){
            return BigDecimal.ZERO;
        }

        return total;
    }



    public List<Object[]> gastosCategoria(Integer id){

        return repository.gastosPorCategoria(id);

    }



    public List<Transacao> ultimasTransacoes(Integer id){

        return repository.ultimasTransacoes(id);

    }

    public BigDecimal gastoEntreDatas(
            Integer id,
            LocalDate inicio,
            LocalDate fim
    ){

        BigDecimal valor = repository.gastoPeriodo(
                id,
                inicio,
                fim
        );


        return valor == null 
                ? BigDecimal.ZERO 
                : valor;

    }


}