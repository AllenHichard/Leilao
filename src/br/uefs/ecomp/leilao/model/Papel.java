/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.model;

/**
 * A classe Papel é uma classe que gera herança dentre papeis, responsável, de
 * gerar métodos que serão herdados por suas classes herdadas.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Papel {

    /**
     * O controller não inicializa nenhum atributo.
     */
    public Papel() {

    }

    /**
     * Verifica se o papel é do tipo papel Comprador
     *
     * @param obj
     * @return true ou false
     */
    public boolean equalsComprador(Object obj) {
        return obj instanceof PapelComprador;
    }

    /**
     * Verifica se o papel é do tipo papel Vendedor
     *
     * @param obj
     * @return true ou false
     */
    public boolean equalsVendedor(Object obj) {
        return obj instanceof PapelVendedor;
    }

    /**
     * Verifica se o papel é do tipo papel Operador
     *
     * @param obj
     * @return true ou false
     */
    public boolean equalsOperador(Object obj) {
        return obj instanceof PapelOperador;

    }
}
