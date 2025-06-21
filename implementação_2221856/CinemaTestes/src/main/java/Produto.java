
public class Produto {
    private int id;
    private String nome;
    private String tipo;
    private float preco;
    private int stock;

    public Produto(int id, String nome, String tipo, float preco, int stock) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.stock = stock;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPreco() {
        return preco;
    }

    public int getStock() {
        return stock;
    }

    public void atualizarStock(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.stock += quantidade;
    }

    public int getId() {
        return id;
    }

    public void retirarStock(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        if (quantidade > stock) {
            throw new IllegalArgumentException("Stock insuficiente.");
        }
        stock -= quantidade;
    }

    public void editar(String novoNome, String novoTipo, float novoPreco) {
        if (novoNome == null || novoNome.length() < 2) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        this.nome = novoNome;
        this.tipo = novoTipo;
        this.preco = novoPreco;
    }
}
