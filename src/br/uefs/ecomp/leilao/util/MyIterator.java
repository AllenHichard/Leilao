/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.util;

/**
 * O Iterador é uma classe que permite ser utilizada para manipular uma lista
 * encadeada sem fazer nenhum alteração tanto elementar, tanto em sua estrutura.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class MyIterator implements Iterador {

    private Celula no;

    /**
     * Construtor que recebe a lista encadeada, e faz uma cópia desta lista para
     * um no do mesmo tipo
     *
     * @param primeiro
     */
    public MyIterator(Celula primeiro) {
        no = primeiro;
    }

    /**
     * Método que verifica se a lista está vazia no momento, retornando um
     * verdadeiro caso ainda tenha elementos nessa lista, e falso para não
     * existir mais elementos na lista.
     *
     * @return true ou false
     */
    @Override
    public boolean temProximo() {
        return no != null;
    }

    /**
     * Método que após verificação se temPróximo, retorna o objeto desejado.
     * Antes do retorno o auxiliar avança uma posição, e assim sucessivamente
     * até o temPróximo for falso (Caracteristica de não exixtir mais elementos
     * na lista.)
     *
     * @return objecto
     */
    @Override
    public Object proximo() {
        Object corrente = no.getObjeto();
        no = no.getProx();
        return corrente;

    }
}
