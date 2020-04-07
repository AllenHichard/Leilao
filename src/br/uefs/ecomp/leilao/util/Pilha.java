/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uefs.ecomp.leilao.util;

/**
 * A classe Fila Encadeada é um tipo de lista com um comportamento especial.
 * DIferentemente de uma lista genericamente encadeada.
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Pilha implements IPilha{
    ListaEncadeada pilha;
    /**
     * caso queira veficar o funcionamento dos métodos, chegar essa documentação principal,
     * clique e vá para a página.
     * {@link ListaEncadeada}
     */
    public Pilha(){
        pilha = new ListaEncadeada();
    }
    @Override
    public Object removeTopo() {
        return pilha.removeInicio();
    }

    @Override
    public void insereTopo(Object obj) {
        pilha.insereInicio(obj);
    }

    @Override
    public Object recuperaTopo() {
        return pilha.recupera(0);
    }

    @Override
    public int tamanho() {
        return pilha.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return pilha.estaVazia();
    }
    public Iterador iterator(){
    return pilha.iterador();
    }
    
}
