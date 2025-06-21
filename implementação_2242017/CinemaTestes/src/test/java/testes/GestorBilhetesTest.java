package testes;

import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorBilhetesTest {

    @Test
    public void testComprarBilheteComLugaresValidos() {
        Lugar lugar1 = new Lugar("A", 1);
        Lugar lugar2 = new Lugar("A", 2);
        List<Lugar> todos = Arrays.asList(lugar1, lugar2);

        Sessao sessao = new Sessao(1, todos);
        GestorBilhetes gestor = new GestorBilhetes();

        Bilhete bilhete = gestor.comprarBilhete(sessao, Arrays.asList(lugar1, lugar2));

        assertEquals(2, bilhete.getLugares().size());
        assertTrue(lugar1.isOcupado());
        assertTrue(lugar2.isOcupado());

        System.out.println("\n🎟️ BILHETE COMPRADO COM SUCESSO");
        for (Lugar l : bilhete.getLugares()) {
            System.out.println("Lugar reservado: " + l.getIdentificador());
        }
    }

    @Test
    public void testComprarBilheteComLugarOcupado() {
        Lugar lugar1 = new Lugar("B", 1);
        Lugar lugar2 = new Lugar("B", 2);
        List<Lugar> todos = Arrays.asList(lugar1, lugar2);

        Sessao sessao = new Sessao(2, todos);
        GestorBilhetes gestor = new GestorBilhetes();


        Bilhete bilhete1 = gestor.comprarBilhete(sessao, Arrays.asList(lugar1));
        assertTrue(lugar1.isOcupado());

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            gestor.comprarBilhete(sessao, Arrays.asList(lugar1, lugar2));
        });

        assertEquals("Lugar B1 indisponível.", excecao.getMessage());

        System.out.println("\n🚫 ERRO AO COMPRAR BILHETE:");
        System.out.println("Motivo: " + excecao.getMessage());
    }
}