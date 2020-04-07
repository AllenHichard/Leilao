/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.model;

/**
 * A classe Usuário, é responsável por criar cada usuário que poderá assumir um
 * Papel dentro do leilão
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class Usuario {

    private int id;
    private String nome;
    private String endereco;
    private Papel papel;
    private String cpf;

    /**
     * O construtor da classe Usuário, inicializa os atributos de sua classe
     * gerando um novo usuário para ser cadastrado no sistema.
     *
     * @param id
     * @param cpf
     * @param nome
     * @param endereco
     */
    public Usuario(int id, String cpf, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    /**
     * O método mudarPapel, recebe o tipo de Papel herdado para que o usuário
     * tenha um tipo de comportamento no leilão.
     *
     * @param papel
     */
    public void mudarPapel(Papel papel) {
        this.papel = papel;
    }

    /**
     * Retorna o papel que o Usuário tem em um determinado leilão
     *
     * @return
     */
    public Papel getPapel() {
        return papel;
    }

    /**
     * O método getId retorna o id do usuário gerado de ordem crescente e
     * automático
     *
     * @return
     */

    public int getId() {
        return id;
    }

    /**
     * O método getNome retorna o nome do usuário.
     *
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     * O método setId modifica o Id do Usuario, só utilizado para testes.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * O método setNome, modifica o nome do usuário apenas utilizado para
     * testes.
     *
     * @param nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * O método getEnrereço retorna o endereço do usuário.
     *
     * @return
     */
    public String getEndereço() {
        return endereco;
    }

    /**
     * O metodo getCpf retorna o CPF do usuário.
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * O método equal, verifica se um objeto objeto passado é do tipo usuario.
     * Se for Usuario o Método verifica o CPF o nome e o seu Id para verificar
     * se os usuários são iguais.
     *
     * @param obj
     * @return true pu false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario o = (Usuario) obj;
            if (nome.equals(o.nome) && cpf.equals(o.cpf) && id == o.id) {
                return true;
            }
        }
        return false;
    }

}
