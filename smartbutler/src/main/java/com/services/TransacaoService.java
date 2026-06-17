package com.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.CriarTransacaoDTO;
import com.entities.Categoria;
import com.entities.Transacao;
import com.entities.Utilizador;
import com.enums.TipoTransacao;
import com.exceptions.UtilizadorInexistenteException;
import com.repositories.CategoriaRepository;
import com.repositories.TransacaoRepository;
import com.repositories.UtilizadorRepository;


@Service
public class TransacaoService {
    private final UtilizadorRepository utilizadorRepository;
    private final CategoriaRepository categoriaRepository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(UtilizadorRepository utilizadorRepository, CategoriaRepository categoriaRepository,
            TransacaoRepository transacaoRepository) {
        this.utilizadorRepository = utilizadorRepository;
        this.categoriaRepository = categoriaRepository;
        this.transacaoRepository = transacaoRepository;
    }


    public List<Transacao> listarTransacoesUtilizador(Integer id){
        return transacaoRepository.findByUtilizador(id);

    }


    public BigDecimal calcularTotalGasto(Integer id){
        BigDecimal total = transacaoRepository.totalGasto(id);

        if(total == null){
            return BigDecimal.ZERO;
        }

        return total;
    }



    public List<Object[]> gastosCategoria(Integer id){

        return transacaoRepository.gastosPorCategoria(id);

    }



    public List<Transacao> ultimasTransacoes(Integer id){

        return transacaoRepository.ultimasTransacoes(id);

    }

    public BigDecimal gastoEntreDatas(
            Integer id,
            LocalDate inicio,
            LocalDate fim
    ){

        BigDecimal valor = transacaoRepository.gastoPeriodo(
                id,
                inicio,
                fim
        );


        return valor == null 
                ? BigDecimal.ZERO 
                : valor;

    }


    public Transacao criar(CriarTransacaoDTO dto) {
        Utilizador user = this.utilizadorRepository
                   .findById(dto.getUtilizadorId())
                   .orElse(null);

        if (user == null) {
            throw new UtilizadorInexistenteException("" + dto.getUtilizadorId());
        }

        String nomeCategoria = dto.getCategoria().trim();

        Categoria categoria = this.categoriaRepository
                    .findByNome(nomeCategoria)
                    .orElse(null);

        if (categoria == null) {
            categoria = new Categoria(nomeCategoria);
            categoria = categoriaRepository.save(categoria);
        }

        TipoTransacao tipo = TipoTransacao.valueOf(dto.getTipo().trim().toUpperCase());

        Transacao transacao = new Transacao(
            user, 
            categoria,
            dto.getDescricao(),
            tipo,
            dto.getValor()
        );

        return transacaoRepository.save(transacao);

    }


}