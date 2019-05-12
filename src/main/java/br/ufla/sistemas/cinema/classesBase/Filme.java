/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

public class Filme {
    private String nome;
    private String sinopse;
    private String[] elenco;//principais atores do filme
    private final int minutos;

    public Filme(String nome, String sinopse, String[] elenco, int minutos) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.elenco = elenco;
        this.minutos = minutos;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getElenco() {
        String elenco = "";
        for(int i = 0; i < this.elenco.length; i++){
            elenco += ' ' + this.elenco[i];
        }
        
        return elenco;
    }

    public int getMinutos() {
        return minutos;
    }
    
    
}
