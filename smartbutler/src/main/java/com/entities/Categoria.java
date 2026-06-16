package com.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;

    public Categoria(String nome,String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria() {
        this.nome = "";
        this.descricao = "";
    }

    public Categoria(Categoria c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria clone() {
        return new Categoria(this);
    }
    
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Categoria c = (Categoria) o;
        return Objects.equals(this.id,c.getId()) &&
               c.getNome().equals(this.nome) &&
               c.getDescricao().equals(this.descricao);
    }

    public String toString() {
        return "categoria = " + this.nome;
    }

}   
