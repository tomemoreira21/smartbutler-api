package com.dto;

import java.math.BigDecimal;

public class CriarTransacaoDTO {
    private Integer utilizadorId;
    private String categoria;
    private BigDecimal valor;
    private String descricao;
    private String tipo;

    public CriarTransacaoDTO(Integer utilizadorId, String categoria, BigDecimal valor, String descricao, String tipo) {
        this.utilizadorId = utilizadorId;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(Integer utilizadorId) {
        this.utilizadorId = utilizadorId;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    

}
