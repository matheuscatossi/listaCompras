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

}
