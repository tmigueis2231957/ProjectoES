package testes;

import modelo.*;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class GestorCarrinhoTest {

    @Test
    public void testAdicionarPacote() { //Testar criação de um novo pacote
        Carrinho carrinho = new Carrinho();
        GestorCarrinho gestor = new GestorCarrinho(carrinho);

        Pacote pacote = new Pacote(1, "Pack Clássico", "Pipocas médias + Bebida média", 4.00f, Collections.emptyList());

        gestor.adicionarPacote(pacote);

        // Verifica se foi adicionado
        assertEquals(1, carrinho.getPacotes().size());

        // Mostra no terminal
        Pacote resultado = carrinho.getPacotes().get(0);
        System.out.println("Pacote adicionado: " + resultado.getNome() + "," + resultado.getDescricao() + ", Preço: " + resultado.getPreco() + "€");
    }

    @Test
    public void testAdicionarPacoteECalcularTotal() { //Testar adicionar pacote ao carrinho e calcular total
        Carrinho carrinho = new Carrinho();
        GestorCarrinho gestor = new GestorCarrinho(carrinho);

        Pacote pacote1 = new Pacote(1, "Pack Clássico", "Pipocas médias + Bebida média", 4.0f, Collections.emptyList());
        Pacote pacote2 = new Pacote(2, "Pack Duplo", "2 Pipocas médias + 2 Bebidas médias", 7.0f, Collections.emptyList());

        gestor.adicionarPacote(pacote1);
        gestor.adicionarPacote(pacote2);

        float totalEsperado = 11.0f;
        float totalCalculado = carrinho.calcularTotal();

        assertEquals(totalEsperado, totalCalculado, 0.001); // margem para floats
        System.out.println("\n======= CARRINHO DE COMPRAS =======");
        int i = 1;
        for (Pacote p : carrinho.getPacotes()) {
            System.out.println("Pacote " + i++ + ":");
            System.out.println("  Nome       : " + p.getNome());
            System.out.println("  Descrição  : " + p.getDescricao());
            System.out.println("  Preço      : €" + p.getPreco());
            System.out.println("-----------------------------------");
        }
        System.out.println("TOTAL A PAGAR: €" + totalCalculado);
        System.out.println("===================================\n");
    }

    @Test
    public void testEditarPacoteExistente() {

        Pacote pacote = new Pacote(1, "PACK ORIGINAL", "ORIGINAL", 3.0f, Collections.emptyList());

        // ORIGINAL
        System.out.println("\n📦 PACOTE ORIGINAL:");
        System.out.println("Nome       : " + pacote.getNome());
        System.out.println("Descrição  : " + pacote.getDescricao());
        System.out.println("Preço      : " + pacote.getPreco() + "€");

        // EDITADO
        pacote.setNome("Pack Premium");
        pacote.setDescricao("Pipocas grandes + Bebida");
        pacote.setPreco(6.5f);

        assertEquals("Pack Premium", pacote.getNome());
        assertEquals("Pipocas grandes + Bebida", pacote.getDescricao());
        assertEquals(6.5f, pacote.getPreco(), 0.001);

        System.out.println("\n✏️ PACOTE EDITADO:");
        System.out.println("Nome       : " + pacote.getNome());
        System.out.println("Descrição  : " + pacote.getDescricao());
        System.out.println("Preço      : " + pacote.getPreco() + "€");
    }

}