package modelo;

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
}