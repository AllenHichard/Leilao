package br.uefs.ecomp.leilao.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompradorTest {

    private Usuario c;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        c = new Usuario(1, "12345678989", "Maria do Carmo", "Rua X");
        Papel papel = new PapelComprador();
        c.mudarPapel(papel);

    }

    /**
     * Teste de unidade que verifica se os atributos de um paciente são
     * atribuidos e modificados corretamente. Além disso, ele checa se o método
     * equals que compara dois pacientes foi implementado corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals(1, c.getId());
        assertEquals("Maria do Carmo", c.getNome());

        c.setId(10);
        c.setNome("Antônia do Carmo");
        assertEquals(10, c.getId());
        assertEquals("Antônia do Carmo", c.getNome());

        Usuario temp = new Usuario(10, "12345678989", "Antônia do Carmo", "Rua X");
        Papel papel2 = new PapelComprador();
        temp.mudarPapel(papel2);
        assertTrue(temp.equals(c));

        c.setId(1);
        assertFalse(temp.equals(c));

        c.setId(10);
        c.setNome("João do Carmo");
        assertFalse(temp.equals(c));
    }
}
