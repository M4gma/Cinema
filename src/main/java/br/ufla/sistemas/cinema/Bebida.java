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
public class Bebida extends Lanche{
    private float volume;
    private String unidadeVolume;

    public Bebida(String nome, int preco, int gramas, float calorias, float litros) {
        super(nome, preco, gramas, calorias);
        
        if(litros < 1.0){
            this.volume = litros * 1000;
            this.unidadeVolume = "ml";
        } else {
            this.volume = litros;
            this.unidadeVolume = "l";
        }
        
    }

    public float getVolume() {
        return volume;
    }

    public String getUnidadeVolume() {
        return unidadeVolume;
    }
    
    
}
