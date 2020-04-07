package br.uefs.ecomp.leilao.util;

public interface IFila {

    /**
     * Verifica se a fila está vazia.
     *
     * @return verdadeiro, se a fila estiver vazia e falso caso contrário.
     */
    public boolean estaVazia();

    /**
     * Quantidade de objetos armazenados na fila
     *
     * @return o tamanho da fila.
     */
    public int tamanho();

    /**
     * Insere um objeto no final da fila.
     *
     * @param o objeto a ser inserido no final da fila.
     */
    public void insereFinal(Object o);

    /**
     * Remove um objeto do início da fila.
     *
     * @return o objeto removido do início da fila.
     */
    public Object removeInicio();

    /**
     * Recupera um objeto do início da fila sem removê-lo.
     *
     * @return o objeto armazenado no início da fila.
     */
    public Object recuperaInicio();
}
