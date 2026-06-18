package com.ai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.enums.AcaoChat;

public class ChatIntentDTO {
    private AcaoChat acao;
    private String categoria;
    private BigDecimal valor;
    private String descricao;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ChatIntentDTO(AcaoChat acao, String categoria, BigDecimal valor, String descricao, String tipo, LocalDate inicio, LocalDate fim) {
        this.acao = acao;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataInicio = inicio;
        this.dataFim = fim;
    }

    public AcaoChat getAcao() {
        return acao;
    }

    public void setAcao(AcaoChat acao) {
        this.acao = acao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    


}
