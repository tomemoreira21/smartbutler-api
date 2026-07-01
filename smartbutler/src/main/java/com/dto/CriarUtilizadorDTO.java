package com.dto;

public class CriarUtilizadorDTO {
    private String nome;
    private String email;

    public CriarUtilizadorDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public CriarUtilizadorDTO() {
        
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


}
