/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.util.List;

/**
 *
 * @author Lúcio
 */
public class Sala {
    private int poltronas[];
    private boolean ocupada = false;
    
    public class Poltrona {
        private char fileira;
        private int assento;
        private Sala sala;

        private Poltrona(Sala sala, char fileira, int assento) {
            this.fileira = fileira;
            this.assento = assento;
            this.sala = sala;
        }

        public char getFileira() {
            return fileira;
        }

        public int getCadeira() {
            return assento;
        }
    
        public String getCodigo(){
            return fileira + Integer.toString(assento);
        }
    
    }

    public Sala(int[] poltronas) throws Throwable {
        Throwable ArrayInvalida = new Throwable("A array é invalida.");
        
        if(poltronas.length > 0 && poltronas.length <= 26/*número de letras do alfabeto*/){            
            for(int i = 0; i < poltronas.length; i++){
                if(poltronas[i] <= 0) throw ArrayInvalida;
            }
            
            this.poltronas = poltronas;
        } else {
            throw ArrayInvalida;
        }
    }
    
    Poltrona getPoltrona(char fileira, int assento) throws Throwable{
        Throwable PoltronaInvalida = new Throwable("Não existe esta poltrona na sala");
        if((fileira - 'A') > poltronas.length || fileira < 'A'){
            throw PoltronaInvalida;
        }
        
        int numeroAssentos = poltronas[fileira - 'A'];
        
        if(numeroAssentos < assento){
            throw PoltronaInvalida;
        }
        
        return new Poltrona(this, fileira, assento);        
    }
}
