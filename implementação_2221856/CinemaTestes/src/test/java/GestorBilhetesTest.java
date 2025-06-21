import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorBilhetesTest {

    @Test
    public void testComprarBilheteComLugaresDisponiveis() {
        Lugar l1 = new Lugar("A", 1);
        Lugar l2 = new Lugar("A", 2);
        Sessao sessao = new Sessao(1, Arrays.asList(l1, l2));

        GestorBilhetes gestor = new GestorBilhetes();
        Bilhete bilhete = gestor.comprarBilhete(sessao, Arrays.asList(l1, l2));

        assertEquals(2, bilhete.getLugares().size());
        assertTrue(l1.isOcupado());
        assertTrue(l2.isOcupado());
    }

    @Test
    public void testComprarBilheteComLugarOcupado() {
        Lugar l1 = new Lugar("B", 1);
        Lugar l2 = new Lugar("B", 2);
        l1.ocupar(); // já está ocupado

        Sessao sessao = new Sessao(2, Arrays.asList(l1, l2));
        GestorBilhetes gestor = new GestorBilhetes();

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            gestor.comprarBilhete(sessao, Arrays.asList(l1, l2));
        });

        assertEquals("Lugar B1 indisponível.", excecao.getMessage());
    }

    @Test
    public void testComprarBilheteComLugarInexistenteNaSessao() {
        Lugar l1 = new Lugar("C", 1); // não pertence à sessão
        Lugar l2 = new Lugar("C", 2);
        Sessao sessao = new Sessao(3, Collections.singletonList(l2)); // só inclui l2

        GestorBilhetes gestor = new GestorBilhetes();

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            gestor.comprarBilhete(sessao, Arrays.asList(l1));
        });

        assertEquals("Lugar C1 indisponível.", excecao.getMessage());
    }

    @Test
    public void testBilheteMantemSessaoEOrdenacao() {
        Lugar l1 = new Lugar("D", 1);
        Lugar l2 = new Lugar("D", 2);
        Sessao sessao = new Sessao(4, Arrays.asList(l1, l2));

        GestorBilhetes gestor = new GestorBilhetes();
        Bilhete bilhete = gestor.comprarBilhete(sessao, Arrays.asList(l2, l1));

        assertEquals(sessao, bilhete.getSessao());
        assertEquals(Arrays.asList(l2, l1), bilhete.getLugares());
    }
}