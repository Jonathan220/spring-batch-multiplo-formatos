package br.com.jonathan.arquivo_multiplo_formato.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;
    private List<Transacao> transacaos = new ArrayList<>();
    
    public Cliente() {
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", email=" + email + (this.transacaos.isEmpty() ? "" : ", transacoes=" + transacaos) + "]";
    }

    public List<Transacao> getTransacaos() {
        return transacaos;
    }

    public void setTransacaos(List<Transacao> transacaos) {
        this.transacaos = transacaos;
    }
    
}
