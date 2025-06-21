package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos = new ArrayList<>();
    private List<Pacote> pacotes = new ArrayList<>();

    public void adicionarPacote(Pacote pacote) {
        pacotes.add(pacote);
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public float calcularTotal() {
        float total = 0;
        for (Pacote p : pacotes) {
            total += p.getPreco();
        }
        return total;
    }
}