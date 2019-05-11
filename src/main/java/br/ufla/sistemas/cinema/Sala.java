/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lúcio
 */
public class Sala {
    private Fileira[] fileiras;
    private boolean ocupada = false;
    
    public class Fileira{
        private final char nome;
        private final Poltrona[] poltronas;
        
        private Fileira(char nome, Poltrona[] poltronas){
            this.nome = nome;
            this.poltronas = poltronas;
        }
        
        public int numDePoltronas(){
            return poltronas.length;
        }

        public char getNome() {
            return nome;
        }

        public Poltrona getPoltrona(int assento) {
            return poltronas[assento];
        }
    }
    
    public class Poltrona {
        private final char fileiraNome;
        private final int assento;
        private final Sala sala;

        private Poltrona(Sala sala, char fileiraNome, int assento) {
            this.fileiraNome = fileiraNome;
            this.assento = assento;
            this.sala = sala;
        }
        
        public String getNome(){
            return fileiraNome + Integer.toString(assento);
        }

        public Fileira getFileira() {
            Fileira fileira = null;
            
            try {
                fileira = sala.getFileira(fileiraNome);
            } catch (Throwable ex) {
                Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return fileira;
        }

        public char getFileiraNome() {
            return fileiraNome;
        }

        public int getAssento() {
            return assento;
        }
    
    }

    public Sala(int[] poltronas) throws Throwable {
        Throwable ArrayInvalida = new Throwable("A array é invalida.");
        
        if(poltronas.length > 0 && poltronas.length <= 25/*número de letras do alfabeto - 1*/){
            fileiras = new Fileira[poltronas.length];
            
            for(int i = 0; i < poltronas.length; i++){
                if(poltronas[i] <= 0) throw ArrayInvalida;
                else{
                    
                    Poltrona[] fileira = new Poltrona[poltronas[i]];
                    
                    for(int j = 0; j < poltronas[i]; j++){
                        fileira[j] = new Poltrona(this, (char)('A' + i), j);
                    }
                    
                    fileiras[i] = new Fileira((char)('A' + i), fileira);
                }
            }
            this.fileiras = fileiras;
        } else {
            throw ArrayInvalida;
        }
    }

    public Fileira[] getFileiras() {
        return fileiras;
    }
    
    public Fileira getFileira(char nome) throws Throwable{
        int idx = nome - 'A';
        if(idx < 0 || idx > 25/*número de letras do alfabeto - 1*/){
            throw new Throwable("Valor de nome inválido.");
        }
        
        return fileiras[idx];
    }

    public boolean isOcupada() {
        return ocupada;
    }
    
    public int numDeFileiras(){
        return fileiras.length;
    }
    
    public int numDePoltronas(){
        int cont = 0;
        for(int i = 0; i < fileiras.length; i++){
            cont += fileiras[i].numDePoltronas();
        }
        
        return cont;
    }
    
}
