package br.com.jonathan.arquivo_multiplo_formato.entities;

public class Transacao {

    private String id;
    private String descricao;
    private Double valor;
    
    public Transacao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
    }

}
