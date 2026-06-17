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

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
        this.nome = "";
    }

    public Categoria(Categoria c) {
        this.id = c.getId();
        this.nome = c.getNome();
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
               c.getNome().equals(this.nome);
    }

    public String toString() {
        return "categoria = " + this.nome;
    }

}   
