package com.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
        name = "utilizador_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_transacao_utilizador")
    )
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(
        name = "categoria_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_transacao_categoria")
    )
    private Categoria categoria;

    private String descricao;

    @Column(
        precision = 10,
        scale = 2,
        nullable = false
    )
    private BigDecimal valor;

    @Column(name = "data_transacao", nullable = false)
    private LocalDate dataTransacao;

    public Transacao(Utilizador u,Categoria c, String descricao, BigDecimal valor) {
        this.utilizador = u;
        this.categoria = c;
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = LocalDate.now();
    }

    public Transacao() {
        this.utilizador = new Utilizador();
        this.categoria = new Categoria();
        this.descricao = "";
        this.valor = null;
        this.dataTransacao = LocalDate.now();
    }

    public Transacao(Transacao t) {
        this.id = t.getId();
        this.utilizador = t.getUtilizador();
        this.categoria = t.getCategoria();
        this.descricao = t.getDescricao();
        this.valor = t.getValor();
        this.dataTransacao = this.getDataTransacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Transacao clone() {
        return new Transacao(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Transacao t = (Transacao) o;
        return Objects.equals(t.getId(), this.id) &&
               t.getUtilizador().equals(this.utilizador) &&
               t.getCategoria().equals(this.categoria) &&
               t.getDescricao().equals(this.descricao) &&
               t.getValor().equals(this.valor) &&
               t.getDataTransacao().equals(this.dataTransacao);
    }

    public String toString() {
        return "user = " + this.utilizador + ", categoria = " + this.categoria
            + ", valor = " + this.valor + ", data = " + this.dataTransacao;
    }

}
