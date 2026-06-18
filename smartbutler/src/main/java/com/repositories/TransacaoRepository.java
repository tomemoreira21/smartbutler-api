package com.repositories;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    // devolve as transacoes de um determina utilizador
    @Query(
        value = """
            SELECT * 
            FROM Transacao
            WHERE utilizador_id = :id        
                """,
            nativeQuery = true
    )
    List<Transacao> findByUtilizador(Integer id);

    // valor total gasto pelo utilizador
    @Query(
    value = """
        SELECT SUM(valor)
        FROM Transacao
        WHERE utilizador_id = :id AND tipo = 'DESPESA'
        """,
        nativeQuery = true
    )
    BigDecimal totalGasto(Integer id);

    // gastos por categoria
    @Query(
    value = """
        SELECT 
            c.nome,
            SUM(t.valor)
        FROM Transacao t
        JOIN Categoria c 
            ON t.categoria_id = c.id
        WHERE t.utilizador_id = :id AND tipo = 'DESPESA'
        GROUP BY c.nome
    """,
        nativeQuery = true
    )
    List<Object[]> gastosPorCategoria(Integer id);

    // obter as últimas 10 transacoes
    @Query(
    value = """
        SELECT *
        FROM Transacao
        WHERE utilizador_id = :id
        ORDER BY data_transacao DESC
        LIMIT 10
    """,
        nativeQuery = true
    )
    List<Transacao> ultimasTransacoes(Integer id);

    // obter os gastos num periodo de tempo
    @Query(
    value = """
        SELECT SUM(valor)
        FROM Transacao
        WHERE utilizador_id = :id AND tipo = 'DESPESA'
        AND data_transacao BETWEEN :inicio AND :fim
    """,
    nativeQuery = true
    )
    BigDecimal gastoPeriodo(
            Integer id,
            LocalDate inicio,
            LocalDate fim
    );

    @Query(
    value = """
        SELECT SUM(valor)
        FROM Transacao
        WHERE utilizador_id = :id
        AND tipo = 'RECEITA'
        """,
     nativeQuery = true)
    BigDecimal totalReceitas(Integer id);



    
}

