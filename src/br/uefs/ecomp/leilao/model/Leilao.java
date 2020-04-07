/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.model;

/**
 * A classe Leilao é responsável para criar cada Leilão, contendo seu produto
 * seu ganhador caso tenha, dentre outras informações para seu cadastro.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Leilao {

    private int id;
    private double lanceAtual;
    private boolean status;
    private boolean iniciado;
    private Produto produto;
    private Usuario ganhador;

    /**
     * O construtor da classe Leilao, inicializa seus atributos.
     *
     * @param id
     * @param lanceAtual
     * @param status
     */
    public Leilao(int id, double lanceAtual, boolean status) {
        this.id = id;
        this.lanceAtual = lanceAtual;
        this.status = status;
    }

    /**
     * O método getId retorna o atributo id do leilão.
     *
     * @return o id do leilão
     */
    public int getId() {
        return id;
    }

    /**
     * O método getStatus retorna o atributo Status do Leilao, status esse se o
     * leilão foi encerrado ou não.
     *
     * @return o status do leilão.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * O método setStatus modifica o status de finalizado do Leilão.
     *
     * @param status true ou false
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * O método getIniciado retorna o leilão já foi iniciado ou não.
     *
     * @return true ou false
     */

    public boolean getIniciado() {
        return iniciado;
    }

    /**
     * O método setIniciado modifica o status iniciado do leilão.
     *
     * @param iniciado
     */

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    /**
     * O método setProduto atualiza o produto que será leiloado.
     *
     * @param produto
     */

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * O método getProduto retorna o produto do leilão.
     *
     * @return
     */

    public Produto getProduto() {
        return produto;

    }

    /**
     * O método setLanceAtual, atualiza o lance de acordo com os lances dado
 pelo usuário.
     *
     * @param lanceAtual
     */

    public void setLanceAtual(double lanceAtual) {
        this.lanceAtual = lanceAtual;
    }

    /**
     * retorna o lance atual(o lance atual maior dentre os lance).
     *
     * @return
     */

    public double getLanceAtual() {
        return lanceAtual;
    }

    /**
     * O método getGanhador retorna o ganhador do leilão
     *
     * @return
     */

    public Usuario getGanhador() {
        return ganhador;
    }

    /**
     * O método setGanhador, atualiza o ganhador de acordo com o maior lance.
     *
     * @param usuario
     */

    public void setGanhador(Usuario usuario) {
        this.ganhador = usuario;
    }

}
