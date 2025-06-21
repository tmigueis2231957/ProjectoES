import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testCriarProduto() {
        Produto p = new Produto(1, "Pipocas", "Snack", 2.50f, 10);
        assertEquals("Pipocas", p.getNome());
        assertEquals("Snack", p.getTipo());
        assertEquals(2.50f, p.getPreco());
        assertEquals(10, p.getStock());
    }

    @Test
    public void testAtualizarStockComValorPositivo() {
        Produto p = new Produto(2, "Refrigerante", "Bebida", 1.80f, 20);
        p.atualizarStock(5);
        assertEquals(25, p.getStock());
    }

    @Test
    public void testAtualizarStockComZero() {
        Produto p = new Produto(3, "Chocolate", "Doce", 1.20f, 15);
        p.atualizarStock(0);
        assertEquals(15, p.getStock());
    }

    @Test
    public void testAtualizarStockComValorNegativoLancaExcecao() {
        Produto p = new Produto(4, "Água", "Bebida", 1.00f, 30);
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            p.atualizarStock(-3);
        });
        assertEquals("Quantidade deve ser positiva.", excecao.getMessage());
    }

    @Test
    public void testMultiplaAtualizacaoDeStock() {
        Produto p = new Produto(5, "Cerveja", "Bebida", 2.00f, 5);
        p.atualizarStock(3);
        p.atualizarStock(7);
        assertEquals(15, p.getStock());
    }

    @Test
    public void testRetirarStockComQuantidadeValida() {
        Produto p = new Produto(6, "Pipocas", "Snack", 2.50f, 20);
        p.retirarStock(5);
        assertEquals(15, p.getStock());
    }

    @Test
    public void testRetirarStockComQuantidadeExcessiva() {
        Produto p = new Produto(7, "Refrigerante", "Bebida", 1.80f, 10);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            p.retirarStock(15);
        });
        assertEquals("Stock insuficiente.", e.getMessage());
    }

    @Test
    public void testRetirarStockComValorNegativo() {
        Produto p = new Produto(8, "Água", "Bebida", 1.00f, 10);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            p.retirarStock(-2);
        });
        assertEquals("Quantidade deve ser positiva.", e.getMessage());
    }

    @Test
    public void testEditarProdutoComValoresValidos() {
        Produto p = new Produto(9, "Sumo", "Bebida", 2.00f, 10);
        p.editar("Ice Tea", "Chá", 1.80f);
        assertEquals("Ice Tea", p.getNome());
        assertEquals("Chá", p.getTipo());
        assertEquals(1.80f, p.getPreco());
    }

    @Test
    public void testEditarProdutoComPrecoNegativo() {
        Produto p = new Produto(10, "Bolo", "Doce", 3.00f, 10);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            p.editar("Bolo de Chocolate", "Doce", -1.00f);
        });
        assertEquals("Preço inválido.", e.getMessage());
    }
}