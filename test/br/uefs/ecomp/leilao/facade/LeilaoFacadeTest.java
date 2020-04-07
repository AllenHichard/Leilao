/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.leilao.facade;

import br.uefs.ecomp.leilao.model.Leilao;
import br.uefs.ecomp.leilao.model.Papel;
import br.uefs.ecomp.leilao.model.PapelComprador;
import br.uefs.ecomp.leilao.model.PapelOperador;
import br.uefs.ecomp.leilao.model.PapelVendedor;
import br.uefs.ecomp.leilao.model.Produto;
import br.uefs.ecomp.leilao.model.Usuario;
import br.uefs.ecomp.leilao.util.Iterador;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Classe teste do LeilaoFacade, que inicializa todos os atributos para ser
 * leitos os testes dos métodos a seguir.
 *
 * @author Allen Hichard Marques dos Santos e Alisson vilas Verde
 */
public class LeilaoFacadeTest {

    private LeilaoFacade controller;
    Usuario u1, u2, u3;
    Papel comprador, vendedor, operador;
    Produto p1, p2, p3;
    Iterador it;

    /**
     * Método setUp, cria as referências para a facade do programa, e inicializa
     * alguns atributos para testes.
     */
    @Before
    public void setUp() {
        controller = new LeilaoFacade();
        p1 = new Produto("tv", "led 42 polegadas", 100.0);
        p2 = new Produto("carro", "cross fox", 10000.0);
        p3 = new Produto("moto", "brazuka", 2000.0);
        u1 = new Usuario(1, "04532345355", "paulo", "cidade nova");
        u2 = new Usuario(2, "02342123432", "roberto", "rua nova");
        u3 = new Usuario(3, "03423485738", "kakashi", "konoha");

    }

    /**
     * Teste Cadastrar usuário e listar Usuario, verifica se os usuários estão
     * sendo cadastrados corretamente no sistema. Esse Método teste, testa dois
     * métodos o Usuario e o listar Usuários.
     */
    @Test
    public void testCadastrarUsuarioListarUsuario() {
        controller.cadastrarUsuario("04532345355", "paulo", "cidade nova");
        controller.cadastrarUsuario("02342123432", "roberto", "rua nova");
        controller.cadastrarUsuario("03423485738", "kakashi", "konoha");
        it = controller.listarUsuarios();
        Usuario compare;
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(u1, compare);
        assertNull(compare.getPapel());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(u2, compare);
        assertNull(compare.getPapel());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(u3, compare);
        assertNull(compare.getPapel());
        assertFalse(it.temProximo());
    }

    /**
     * Teste Mudar Papel, verifica se o atributo do usuário está recebendo as
     * trocas de atributos de papel.
     */
    @Test
    public void testMudarPapel() {
        controller.cadastrarUsuario("04532345355", "paulo", "cidade nova");
        controller.cadastrarUsuario("02342123432", "roberto", "rua nova");
        controller.cadastrarUsuario("03423485738", "kakashi", "konoha");
        comprador = new PapelComprador();
        vendedor = new PapelVendedor();
        operador = new PapelOperador();
        it = controller.listarUsuarios();
        Usuario compare;
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        compare.mudarPapel(operador);
        assertNotNull(compare.getPapel());
        assertSame(operador, compare.getPapel());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        compare.mudarPapel(vendedor);
        assertNotNull(compare.getPapel());
        assertSame(vendedor, compare.getPapel());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        compare.mudarPapel(comprador);
        assertNotNull(compare.getPapel());
        assertSame(comprador, compare.getPapel());
        assertFalse(it.temProximo());
    }

    /**
     * Teste Cadastrar Produtos, verifica se os produtos estão sendo cadastrados
     * corretamente no sistema.
     */
    @Test
    public void testCadastrarProduto() {
        controller.cadastrarProduto("tv", "led 42 polegadas", 100.0);
        controller.cadastrarProduto("carro", "cross fox", 10000.0);
        controller.cadastrarProduto("moto", "brazuka", 2000.0);
        it = controller.listarProdutosNaoLeiloados();
        Produto compare;
        assertTrue(it.temProximo());
        compare = (Produto) it.proximo();
        assertEquals(p3.getNome(), compare.getNome());
        assertTrue(it.temProximo());
        compare = (Produto) it.proximo();
        assertEquals(p2.getNome(), compare.getNome());
        assertTrue(it.temProximo());
        compare = (Produto) it.proximo();
        assertEquals(p1.getNome(), compare.getNome());
        assertFalse(it.temProximo());

    }

    /**
     * Teste CadastrarLeilao, verifica se os leilões estão sendo cadastrados
     * corretamente no sistema.
     */
    @Test
    public void testCadastrarLeilao() {
        controller.cadastrarProduto("tv", "led 42 polegadas", 100.0);
        controller.cadastrarProduto("carro", "cross fox", 10000.0);
        controller.cadastrarProduto("moto", "brazuka", 2000.0);
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        it = controller.listarLeiloesAndamendo();
        Leilao compare;
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertFalse(compare.getIniciado());
        assertEquals(p3.getNome(), compare.getProduto().getNome());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertFalse(compare.getIniciado());
        assertEquals(p2.getNome(), compare.getProduto().getNome());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertFalse(compare.getIniciado());
        assertEquals(p1.getNome(), compare.getProduto().getNome());
        assertFalse(it.temProximo());
    }

    /**
     * Teste iniciar Leilão testa um atributo de Leilão, que diz se o leilão
     * está em andamento ou não, e mostra todos os leilões que estão em
     * andamento.
     */
    @Test
    public void testIniciarLeilaoListarLeiloesAndamento() {
        controller.cadastrarProduto("tv", "led 42 polegadas", 100.0);
        controller.cadastrarProduto("carro", "cross fox", 10000.0);
        controller.cadastrarProduto("moto", "brazuka", 2000.0);
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        controller.iniciarLeilao(1);
        controller.iniciarLeilao(2);
        controller.iniciarLeilao(3);
        it = controller.listarLeiloesAndamendo();
        Leilao compare;
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getIniciado());
        assertFalse(compare.getStatus());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getIniciado());
        assertFalse(compare.getStatus());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getIniciado());
        assertFalse(compare.getStatus());
        assertFalse(it.temProximo());

    }

    /**
     * O teste finalizar leilão, verifica se o leilão foi finalizado e também
     * lista todos os leilões finalizados até o exato momento.
     */
    @Test
    public void testFinalizarLeilaoListarLeiloesFinalizados() {
        controller.cadastrarProduto("tv", "led 42 polegadas", 100.0);
        controller.cadastrarProduto("carro", "cross fox", 10000.0);
        controller.cadastrarProduto("moto", "brazuka", 2000.0);
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        controller.cadastrarLeilao();
        controller.iniciarLeilao(1);
        controller.iniciarLeilao(2);
        controller.iniciarLeilao(3);
        controller.finalizarLeilao(1);
        controller.finalizarLeilao(2);
        controller.finalizarLeilao(3);
        it = controller.listarLeiloesAndamendo();
        Leilao compare;
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getStatus());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getStatus());
        assertTrue(it.temProximo());
        compare = (Leilao) it.proximo();
        assertTrue(compare.getStatus());
        assertFalse(it.temProximo());
    }

    /**
     * O teste dar lance, verifica se o usuário está realmente sendo
     * possibilitado de dar lance no leilão. O teste verifica todos os lance e
     * depois diz qual o usuario vencedor.
     */
    @Test
    public void testDarLanceVerificarVencedor() {
        Usuario a = controller.cadastrarUsuario("04532345355", "paulo", "cidade nova");
        Usuario b = controller.cadastrarUsuario("02342123432", "roberto", "rua nova");
        Usuario c = controller.cadastrarUsuario("03423485738", "kakashi", "konoha");
        comprador = new PapelComprador();
        a.mudarPapel(comprador);
        b.mudarPapel(comprador);
        c.mudarPapel(comprador);
        controller.cadastrarProduto("tv", "led 42 polegadas", 100.0);
        controller.cadastrarProduto("carro", "cross fox", 10000.0);
        controller.cadastrarProduto("moto", "brazuka", 2000.0);
        Leilao l1 = controller.cadastrarLeilao();
        Leilao l2 = controller.cadastrarLeilao();
        Leilao l3 = controller.cadastrarLeilao();
        controller.iniciarLeilao(1);
        controller.iniciarLeilao(2);
        controller.iniciarLeilao(3);
        controller.darLance(1, 1, 99.9);
        assertNull(l1.getGanhador());
        controller.darLance(1, 2, 2000.0);
        assertNull(l1.getGanhador());
        controller.darLance(1, 3, 2000.1);
        assertSame(c, l1.getGanhador());
        controller.darLance(2, 1, 12000.1);
        assertNotNull(l2.getGanhador());
        controller.darLance(2, 2, 10000.0);
        assertNotNull(l2.getGanhador());
        controller.darLance(2, 3, 10.0);
        assertSame(a, l2.getGanhador());
        controller.darLance(3, 1, 100.1);
        controller.darLance(3, 2, 300.0);
        controller.darLance(3, 3, 100.15);
        assertSame(b, l3.getGanhador());

        controller.finalizarLeilao(1);
        controller.finalizarLeilao(2);
        controller.finalizarLeilao(3);
        assertSame(c, controller.verificarVencedor(1));
        assertSame(a, controller.verificarVencedor(2));
        assertSame(b, controller.verificarVencedor(3));
    }

    /**
     * O teste Listar Operadores, lista apenas os usuários do tipo PapelOperador
     * do sistema.
     */
    @Test
    public void testListarOperadores() {
        Usuario a = controller.cadastrarUsuario("04532345355", "paulo", "cidade nova");
        Usuario b = controller.cadastrarUsuario("02342123432", "roberto", "rua nova");
        Usuario c = controller.cadastrarUsuario("03423485738", "kakashi", "konoha");
        comprador = new PapelComprador();
        operador = new PapelOperador();
        a.mudarPapel(operador);
        b.mudarPapel(comprador);
        c.mudarPapel(operador);
        it = controller.listarOperadores();
        Usuario compare;
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertSame(compare.getPapel(), operador);
        compare = (Usuario) it.proximo();
        assertSame(compare.getPapel(), operador);
        assertFalse(it.temProximo());
    }

    /**
     * O teste listar Compradores pelo ID, lista todos os compradores ordenados
     * pelo Id e mesmo se o iD for modificado depois, o método também faz a
     * ordenação.
     */
    @Test
    public void testListarCompradoresPeloId() {
        Usuario a = controller.cadastrarUsuario("04532345355", "paulo", "cidade nova");
        Usuario b = controller.cadastrarUsuario("02342123432", "roberto", "rua nova");
        Usuario c = controller.cadastrarUsuario("03423485738", "kakashi", "konoha");
        comprador = new PapelComprador();
        a.mudarPapel(comprador);
        b.mudarPapel(comprador);
        c.mudarPapel(comprador);
        assertEquals(1, a.getId());
        assertEquals(2, b.getId());
        assertEquals(3, c.getId());
        controller.listarCompradoresOrdenadosPeloSeuId();
        it = controller.listarCompradoresOrdenadosPeloSeuId();
        Usuario compare;
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(1, compare.getId());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(2, compare.getId());
        assertTrue(it.temProximo());
        compare = (Usuario) it.proximo();
        assertEquals(3, compare.getId());
        a.setId(5);
        b.setId(1);
        c.setId(3);
        assertEquals(5, a.getId());
        assertEquals(1, b.getId());
        assertEquals(3, c.getId());
        controller.listarCompradoresOrdenadosPeloSeuId();
        Iterador ip = controller.listarCompradoresOrdenadosPeloSeuId();
        Usuario compar;
        compar = (Usuario) ip.proximo();
        assertEquals(1, compar.getId());
        compar = (Usuario) ip.proximo();
        assertEquals(3, compar.getId());
        compar = (Usuario) ip.proximo();
        assertEquals(5, compar.getId());
    }
}
