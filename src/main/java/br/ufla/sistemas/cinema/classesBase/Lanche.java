/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

/**
 *
 * @author lucio
 */
public class Lanche extends Produto{
    private float calorias;

    public Lanche(String nome, int preco, int gramas, float calorias) {
        super(nome, preco, gramas);
        this.calorias = calorias;
    }

    public float getCalorias() {
        return calorias;
    }
}
