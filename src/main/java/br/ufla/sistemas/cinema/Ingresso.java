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
    private Poltrona poltrona;
    
    public Ingresso(Sessao sessao, Poltrona poltrona){
        totais++;
        
        this.sessao = sessao;
        this.poltrona = poltrona;
    }
}
