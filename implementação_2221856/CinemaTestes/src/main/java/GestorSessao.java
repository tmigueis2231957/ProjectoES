
import java.util.*;

public class GestorSessao {
    private Map<Filme, List<Sessao>> sessoesPorFilme = new HashMap<>();

    public void adicionarSessao(Filme filme, Sessao sessao) {
        sessoesPorFilme.putIfAbsent(filme, new ArrayList<>());
        sessoesPorFilme.get(filme).add(sessao);
    }

    public List<Sessao> visualizarTodasAsSessoes() {
        List<Sessao> todas = new ArrayList<>();
        for (List<Sessao> lista : sessoesPorFilme.values()) {
            todas.addAll(lista);
        }
        return todas;
    }

    public List<Sessao> obterSessoesPorFilme(Filme filme) {
        return sessoesPorFilme.getOrDefault(filme, Collections.emptyList());
    }

    public Map<Filme, List<Sessao>> getMapaCompleto() {
        return Collections.unmodifiableMap(sessoesPorFilme);
    }
}
