package modelo;

public class GestorCarrinho {
    private Carrinho carrinho;

    public GestorCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void adicionarPacote(Pacote pacote) {
        carrinho.adicionarPacote(pacote);
    }
}