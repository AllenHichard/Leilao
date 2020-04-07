/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.facade;

import br.uefs.ecomp.leilao.model.Leilao;
import br.uefs.ecomp.leilao.model.Papel;
import br.uefs.ecomp.leilao.model.Produto;
import br.uefs.ecomp.leilao.model.Usuario;
import br.uefs.ecomp.leilao.util.Fila;
import br.uefs.ecomp.leilao.util.Iterador;
import br.uefs.ecomp.leilao.util.ListaEncadeada;
import br.uefs.ecomp.leilao.util.Pilha;

/**
 * A classe LeilaoController faz todo os requisitos do programa. ele recebe e
 * armazena todas as informações para a manipulação de dados do sistema, que é
 * garantir um bom funcionamento quando se falar em Leilões.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class LeilaoController {

    private ListaEncadeada usuario;
    private ListaEncadeada auxiliar;
    private ListaEncadeada ordenada;
    private ListaEncadeada auxProduto;
    private ListaEncadeada operador;
    private Usuario c; 
    private Pilha produto;
    private Fila fila;
    private int idUsuario;
    private int idLeilao;
    private double darLance;
    
    /**
     * O construtor da Classe LeilaoController define todas as inicializações do
     * sistema. Como o sistema precisa de requisitos para o seu funcionamento,
     * ele inicializa os atributos, como por exemplo a Fila para leilões, a
     * Pilha para Produtos.
     */
    public LeilaoController() {
        auxiliar = new ListaEncadeada();
        operador = new ListaEncadeada();
        auxProduto = new ListaEncadeada();
        usuario = new ListaEncadeada();
        produto = new Pilha();
        fila = new Fila();
        ordenada = new ListaEncadeada();
        idUsuario = 1;
        idLeilao = 1;

    }

    /**
     * O método cadastrar usuário, cadastra um novo usuário e armazena ele em
     * uma lista de usuários, para ocorrer futuros leilões.
     *
     * @param cpf
     * @param nome
     * @param endereco
     * @return O usuario cadastrado.
     */
    public Usuario cadastrarUsuario(String cpf, String nome, String endereco) {
        c = new Usuario(idUsuario, cpf, nome, endereco);
        for (int i = 0; i < usuario.tamanho(); i++) {
            Usuario u = (Usuario) usuario.recupera(i);
            if (c.equals(u)) {
                return null;
            }
        }
        usuario.insereFinal(c);
        idUsuario++;
        return c;
    }

    /**
     * O método mudar papel, ele troca o papel do usuário que ele pode conter em
     * leilão. Os papeis podem ser, Comprador, Vendedor e Operador. Lembrando
     * que o usuário só tera um papel por Leilão.
     *
     * @param idUsuario
     * @param papel
     */
    public void mudarPapel(int idUsuario, Papel papel) {
        for (int i = 0; i < usuario.tamanho(); i++) {
            Usuario u = (Usuario) usuario.recupera(i);
            if (u.getId() == idUsuario) {
                u.mudarPapel(papel);
            }
        }
    }

    /**
     * O método cadastrarProduto, realiza o cadastro de produtos na pilha. O
     * cadastro e produtos e feito na seguinte forma: O produto mas atual vai
     * ficando na primeira posição, ou seja a cada produto cadastrado, ele é
     * inserido na frente de todos os outros já cadastrados.
     *
     * @param nome
     * @param descricao
     * @param valor_reserva
     * @return
     */
    public Produto cadastrarProduto(String nome, String descricao, Double valor_reserva) {
        Produto p = new Produto(nome, descricao, valor_reserva);
        produto.insereTopo(p);
        return p;
    }

    /**
     * O método cadastrarLeilao, registra um leilão e armazena em uma fila de
     * leilões.
     *
     * @return O leilão cadastrado
     */
    public Leilao cadastrarLeilao() {
        Leilao l = new Leilao(idLeilao, darLance, false);
        l.setProduto((Produto) produto.recuperaTopo());
        auxProduto.insereFinal(produto.removeTopo());
        fila.insereFinal(l);
        idLeilao++;
        return l;
    }

    /**
     * O método iniciarLeilao, ele recebe o id de um leilão que já está
     * cadastrado no sistema e o inicializa. Caso ele já esteja inicializado o
     * usuário irá receber uma mensagem de leilão em andamento.
     *
     * @param idLeilao
     */
    public void iniciarLeilao(int idLeilao) {
        Iterador it = fila.iterator();
        while (it.temProximo()) {
            Leilao l = (Leilao) it.proximo();
            if (l.getId() == idLeilao) {
                if (l.getIniciado() == true) {
                    System.out.println("esse leilao já foi iniciado");
                } else {
                    l.setIniciado(true);
                }
            }
        }

    }

    /**
     * o método finalizarLeilao, recebe o id do leilão e o torna finalizado. O
     * leilão ele pode ter vendido ou não o produto, após o leilão ocorrer ele
     * salva o produto que foi a leilão em uma Fila de produtos leiloados.
     *
     * @param idLeilao
     */
    public void finalizarLeilao(int idLeilao) {
        Iterador it = fila.iterator();
        while (it.temProximo()) {
            Leilao l = (Leilao) it.proximo();
            if (l.getId() == idLeilao && l.getIniciado() == true) {
                l.setStatus(true);
                if (l.getLanceAtual() > l.getProduto().getValorReserva()) {
                    l.getProduto().setVendido(true);
                }

            }
        }
    }

    /**
     * O método darLance, ele verifica o vencedor do leilão caso haja um
     * vencedor. esse método garante que o produto que vai ser leiloado só será
     * vendido por um preço maior que o valor reversa(Valor inicial que o
     * vendedor cadastra) e maior que todos os lances dos outros compradores.
     *
     * @param idLeilao
     * @param idUsuario
     * @param lance
     */
    public void darLance(int idLeilao, int idUsuario, double lance) {
        Iterador it = fila.iterator();
        Iterador iu = usuario.iterador();
        while (it.temProximo()) {
            Leilao l = (Leilao) it.proximo();
            if (idLeilao == l.getId() && l.getIniciado() == true) {
                while (iu.temProximo()) {
                    Usuario u = (Usuario) iu.proximo();
                    if (u.getId() == idUsuario && u.getPapel().equalsComprador(u.getPapel())) {
                        if (lance > l.getProduto().getValorReserva() && lance > l.getLanceAtual()) {
                            l.setLanceAtual(lance);
                            l.setGanhador(u);

                        }
                    }
                }
            }

        }
    }

    /**
     * O método verificarVencedor, ele verifica pelo id do leilão quem foi seu
     * ganhador.
     *
     * @param idLeilao
     * @return
     */
    public Usuario verificarVencedor(int idLeilao) {
        Iterador it = fila.iterator();

        while (it.temProximo()) {
            Leilao l = (Leilao) it.proximo();
            if (l.getId() == idLeilao) {
                if (l.getStatus() == true) {
                    return l.getGanhador();
                }
            }

        }
        return null;
    }

    /**
     * O método listar leilões em andamento, lista todos os leilões que ainda
     * não foram finalizados.
     *
     * @return o interador de leilões em Andamento
     */
    public Iterador listarLeiloesAndamendo() {
        Iterador it = fila.iterator();
        return it;
    }

    /**
     * O método listar leilões finalizado, lista todos os leilões que já foram
     * finalizados.
     *
     * @return o interador de leilões finalizados.
     */
    public Iterador listarLeiloesFinalizados() {
        Iterador it = fila.iterator();
        return it;

    }

    /**
     * O método listarUsuarios, lista todos os usuários cadastrados no sistema,
     * independente do seu papel.
     *
     * @return O interador da lista de usuários.
     */
    public Iterador listarUsuarios() {
        Iterador it = usuario.iterador();
        return it;
    }

    /**
     * O método listarOperadores, lista todos os usuários que estejam
     * cadastrados com o papel do tipo Operador.
     *
     * @return o Iterador da lista de Operadores.
     */
    public Iterador listarOperadores() {
        Iterador it = usuario.iterador();
        while (it.temProximo()) {
            Usuario u = (Usuario) it.proximo();
            if (u.getPapel().equalsOperador(u.getPapel())) {
                operador.insereFinal(u);
            }
        }
        return operador.iterador();
    }

    /**
     * O método ListarProdutosNaoLeiloados, lista todos os produtos que não
     * foram leiloados. ou seja os produtos que ainda não foram ao leilão. é
     * considerado que todo produto cadastrado já faz parte de um leilão, logo
     * todo produto que ainda não está associado a um leilão, ainda não foi
     * leiloado.
     *
     * @return A lista de Produtos não Leiloados.
     */
    public Iterador listarProdutosNaoLeiloados() {
        Iterador it = produto.iterator();
        return it;
    }

    /**
     * Método que lista todos os compradores por seu id. Todos os ids já foram
     * organizados crescentemente, mas para garantir que a lista sempre estará
     * ordenada foi implementado esse método, como por exemplo: se em algum
     * querer setar o id
     *
     * @return o Iterador dos usuários Compradores
     */
    public Iterador listarCompradoresOrdenadosPeloSeuId() {
        for (int i = 0; i < usuario.tamanho(); i++) {
            int posicao = 0;
            Usuario u = (Usuario) usuario.recupera(i);
            if (u.getPapel().equalsComprador(u.getPapel())) {
                if (auxiliar.tamanho() == 0) {
                    auxiliar.insereOrdenado(u, posicao);
                } else {
                    for (int j = 0; j < auxiliar.tamanho(); j++) {
                        Usuario aux = (Usuario) auxiliar.recupera(j);
                        if (aux.getId() < u.getId()) {
                            posicao++;
                        }
                    }
                    auxiliar.insereOrdenado(u, posicao);
                }
            }
        }
        while (usuario.tamanho() != 0) {
            usuario.removeInicio();
        }
        while (auxiliar.tamanho() != 0) {
            usuario.insereFinal(auxiliar.removeInicio());
        }
        return usuario.iterador();
    }

}
