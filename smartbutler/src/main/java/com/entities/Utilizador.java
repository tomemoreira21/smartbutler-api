package com.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;

// entidade faz com que a classe seja convertida numa tabela SQL
@Entity
@Table(name = "Utilizador")
public class Utilizador {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    public Utilizador(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = LocalDateTime.now(); 
    }

    public Utilizador() {
        this.nome = "";
        this.email = "";
        this.dataCadastro = LocalDateTime.now();
    }

    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.dataCadastro = u.getDataCadastro();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime data_cadastro) {
        this.dataCadastro = data_cadastro;
    }
    
    public Utilizador clone() {
        return new Utilizador(this);
    }
    
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Utilizador u = (Utilizador) o;
        return Objects.equals(u.getId(), this.id) &&
               u.getNome().equals(this.nome) &&
               u.getEmail().equals(this.email) &&
               u.getDataCadastro().equals(this.dataCadastro);
    }

    public String toString() {
        return "nome = " + this.nome + ", email = " + this.email;
    }

}   
