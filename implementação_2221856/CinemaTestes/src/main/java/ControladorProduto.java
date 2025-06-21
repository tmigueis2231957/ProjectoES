
import java.util.HashMap;
import java.util.Map;

public class ControladorProduto {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    public Produto getProdutoPorId(int id) {
        return produtos.get(id);
    }

    public void adicionarStock(int idProduto, int quantidade) {
        Produto produto = produtos.get(idProduto);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        produto.atualizarStock(quantidade);
    }
}