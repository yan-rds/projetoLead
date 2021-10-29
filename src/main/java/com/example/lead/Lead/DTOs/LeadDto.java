package com.example.lead.Lead.DTOs;

import java.util.List;

public class LeadDto {
    private String email;
    private String nome;
    private String telefone;
    private List<ProdutoDto> produtos;

    public LeadDto() {
    }

    public LeadDto(String email, String nome, String telefone, List<ProdutoDto> produtos) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.produtos = produtos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }
}
