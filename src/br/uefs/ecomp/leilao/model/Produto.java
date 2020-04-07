/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.model;

/**
 * A classe Produto, é respomsável por criar o produto para ocorrer o leilão. O
 * produto será cadastrado e poderá ser vendido ou não.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Produto {

    private String nome;
    private String descricao;
    private double valor_reserva;
    private boolean vendido;

    /**
     * O contrutor da classe Produto, inicializa os atributos dessa classe, para
     * gerar um produto a ser cadastrado posteriormente.
     *
     * @param nome
     * @param descricao
     * @param valor_reserva
     */
    public Produto(String nome, String descricao, double valor_reserva) {
        this.valor_reserva = valor_reserva;
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * O método getValorReserva, retorna o valor cadastrado por o vendedor do
     * produto.
     *
     * @return
     */
    public double getValorReserva() {
        return valor_reserva;
    }

    /**
     * O método setVendido recebe o verdadeiro ou false, para verificar se o
     * produto foi vendido ou não. O valor tem que ser maior que o valor reserva
     * para isso ocorrer.
     *
     * @param vendido
     */
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    /**
     * O método getVendido retorna se o produto foi vendido ou não até então.
     *
     * @return True ou False
     */
    public boolean getVendido() {
        return vendido;
    }

    /**
     * O método getNome retorna o nome do Produto.
     *
     * @return Nome do Produto
     */
    public String getNome() {
        return nome;
    }
}
