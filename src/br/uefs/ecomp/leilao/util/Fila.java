/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uefs.ecomp.leilao.util;

/**
 * A classe Fila Encadeada é um tipo de lista com um comportamento especial.
 * DIferentemente de uma lista genericamente encadeada.
 * 
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Fila implements IFila {
    ListaEncadeada fila;
    
    /**
     * caso queira veficar o funcionamento dos métodos, chegar essa documentação principal,
     * clique e vá para a página.
     * {@link ListaEncadeada}
     */
    public Fila(){
        fila = new ListaEncadeada();
    }
   
    @Override
    public boolean estaVazia() {
        return fila.estaVazia();
    }

    @Override
    public int tamanho() {
        return fila.tamanho();
    }

    @Override
    public void insereFinal(Object o) {
        fila.insereFinal(o);
    }

    @Override
    public Object removeInicio() {
        return fila.removeInicio();
    }
    
    
    @Override
    public Object recuperaInicio(){    
    return fila.recupera(0);
    }
    
    public Iterador iterator(){
    return fila.iterador();
    }
    
}
