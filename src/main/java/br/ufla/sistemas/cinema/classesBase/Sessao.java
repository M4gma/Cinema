/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucio
 */
public class Sessao {
    private final Sala sala;
    private final Filme filme;
    private final Date inicioSessao;
    private final Date fimSessao;
    private final Ingresso[] ingressos;
    

    public Sessao(Sala sala, Filme filme, Date inicioSessao) {
        this.sala = sala;
        this.filme = filme;
        this.inicioSessao = inicioSessao;
        this.fimSessao = new Date(inicioSessao.getTime() + (filme.getMinutos() * 60000)); //um minuto tem 60000 milissegundos
        
        Ingresso[] ingressos = new Ingresso[sala.numDePoltronas()];
        
        int cont = 0;
        for(int i = 0; i < sala.numDeFileiras(); i++){
            try {
                
                Sala.Fileira f = sala.getFileira((char)(i + 'A'));
                
                for(int j = 0; j < f.numDePoltronas(); j++){
                    ingressos[cont++] = new Ingresso(this, f.getPoltrona(j));
                }
            
            } catch (Throwable ex){
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        this.ingressos = ingressos;
    }

    public Sala getSala() {
        return sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public Date getInicioSessao() {
        return inicioSessao;
    }

    public Date getFimSessao() {
        return fimSessao;
    }
    
    public Ingresso getIngresso(Sala.Poltrona poltrona) throws Throwable{
        for(int i = 0; i < ingressos.length; i++){
            if(ingressos[i].getPoltrona() == poltrona) return ingressos[i];
        }
        
        throw new Throwable("Poltrona não pertence à mesma sala que a sessão.");
    }
    
}
