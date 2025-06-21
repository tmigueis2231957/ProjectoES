import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorFilme {
    private List<Filme> filmes = new ArrayList<>();

    public void adicionarFilme(Filme f) {
        filmes.add(f);
    }

    public List<Filme> visualizarFilmesEmExibicao() {
        return filmes.stream()
                .filter(f -> f.getEstado().equalsIgnoreCase("Em exibição"))
                .collect(Collectors.toList());
    }

    public List<Filme> getTodosOsFilmes() {
        return new ArrayList<>(filmes);
    }
}
