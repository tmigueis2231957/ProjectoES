import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorFilmeTest {
    @Test
    public void testVisualizarFilmesEmExibicao() {
        GestorFilme gestor = new GestorFilme();
        Filme f1 = new Filme("Inception", "Sci-Fi", 148, "M12", "Em exibição", "Sonhos dentro de sonhos.");
        Filme f2 = new Filme("Titanic", "Romance", 195, "M14", "Removido", "Amor no oceano.");

        gestor.adicionarFilme(f1);
        gestor.adicionarFilme(f2);

        List<Filme> exibicao = gestor.visualizarFilmesEmExibicao();

        assertEquals(1, exibicao.size());
        assertEquals("Inception", exibicao.get(0).getNome());
    }

    @Test
    public void testListaVaziaSemFilmes() {
        GestorFilme gestor = new GestorFilme();
        List<Filme> filmes = gestor.visualizarFilmesEmExibicao();
        assertTrue(filmes.isEmpty());
    }

    @Test
    public void testGetTodosOsFilmes() {
        GestorFilme gestor = new GestorFilme();
        gestor.adicionarFilme(new Filme("Matrix", "Ação", 136, "M16", "Em exibição", "Simulação de realidade."));
        gestor.adicionarFilme(new Filme("Avatar", "Fantasia", 160, "M12", "Em exibição", "Mundo alienígena."));

        List<Filme> todos = gestor.getTodosOsFilmes();
        assertEquals(2, todos.size());
    }
}
