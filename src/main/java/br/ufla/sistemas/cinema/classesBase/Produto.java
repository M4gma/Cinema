/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema.classesBase;

/**
 *
 * @author lucio
 */
public class Produto {
    private String nome;
    private float preco;
    private float peso;
    private String unidadePeso;

    public Produto(String nome, float preco, float gramas) {
        this.nome = nome;
        this.preco = preco;
        this.peso = gramas;
        
        if(gramas < 1000)
            this.unidadePeso = "g";
        else{
            this.peso /= 1000.0;
            this.unidadePeso = "kg";
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public float getPeso() {
        return peso;
    }

    public String getUnidadePeso() {
        return unidadePeso;
    }
    
    
}
