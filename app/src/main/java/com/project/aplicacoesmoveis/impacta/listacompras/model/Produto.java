package com.project.aplicacoesmoveis.impacta.listacompras.model;

/**
 * Created by Matheus on 18/04/2017.
 */

public class Produto {

    int id;
    String nome;
    double valor;
    String categoria;
    boolean favorito;

    public Produto(){

    }

    public Produto(int id, String nome, double valor, String categoria, boolean favorito){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.favorito = favorito;
    }

    public Produto(String nome, double valor, String categoria, boolean favorito) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.favorito = favorito;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
