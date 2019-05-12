/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

/**
 *
 * @author Lúcio
 */
public class Ingresso {
    private static int totais = 0;
    private int id = totais;
    
    private Sessao sessao;
    private Sala.Poltrona poltrona;
    
    public Ingresso(Sessao sessao, Sala.Poltrona poltrona){
        totais++;
        
        this.sessao = sessao;
        this.poltrona = poltrona;
    }

    public static int getTotais() {
        return totais;
    }

    public int getId() {
        return id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public Sala.Poltrona getPoltrona() {
        return poltrona;
    }
    
}
