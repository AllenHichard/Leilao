package br.uefs.ecomp.leilao.facade;

import br.uefs.ecomp.leilao.model.Usuario;
import br.uefs.ecomp.leilao.model.Leilao;
import br.uefs.ecomp.leilao.model.Produto;
import br.uefs.ecomp.leilao.model.Papel;
import br.uefs.ecomp.leilao.util.Iterador;

public class LeilaoFacade {

    private LeilaoController controller;

    public LeilaoFacade() {
        controller = new LeilaoController();
    }

    public Usuario cadastrarUsuario(String cpf, String nome, String endereco) {
        return controller.cadastrarUsuario(cpf, nome, endereco);
    }

    public void mudarPapel(int idUsuario, Papel papel) {
        controller.mudarPapel(idUsuario, papel);
    }

    public Produto cadastrarProduto(String nome, String descricao, Double valor_reserva) {
        return controller.cadastrarProduto(nome, descricao, valor_reserva);
    }

    public Leilao cadastrarLeilao() {
        return controller.cadastrarLeilao();
    }

    public void iniciarLeilao(int idLeilao) {

        controller.iniciarLeilao(idLeilao);
    }

    public void finalizarLeilao(int idLeilao) {

        controller.finalizarLeilao(idLeilao);
    }

    public void darLance(int idLeilao, int idUsuario, double lance) {

        controller.darLance(idLeilao, idUsuario, lance);
    }

    public Usuario verificarVencedor(int idLeilao) {
        return controller.verificarVencedor(idLeilao);
    }

    public Iterador listarLeiloesAndamendo() {
        return controller.listarLeiloesAndamendo();
    }

    public Iterador listarLeiloesFinalizados() {
        return controller.listarLeiloesFinalizados();
    }

    public Iterador listarUsuarios() {
        return controller.listarUsuarios();
    }

    public Iterador listarOperadores() {
        return controller.listarOperadores();
    }

    public Iterador listarProdutosNaoLeiloados() {
        return controller.listarProdutosNaoLeiloados();
    }

    public Iterador listarCompradoresOrdenadosPeloSeuId() {
        return controller.listarCompradoresOrdenadosPeloSeuId();
    }

}
