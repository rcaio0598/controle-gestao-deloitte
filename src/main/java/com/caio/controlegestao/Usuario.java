package com.caio.controlegestao;

public class Usuario {
    private int id;
    private String nome;
    private boolean ativo;
    
    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.ativo = true;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void desativar() {
        this.ativo = false;
    }
    
    public void ativar() {
        this.ativo = true;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Status: %s", 
            id, nome, ativo ? "ATIVO" : "INATIVO");
    }
}
```

