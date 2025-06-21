import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GestorSessaoTest {

    @Test
    public void testAdicionarSessaoEVisualizarTodas() {
        Filme filme = new Filme("Inception", "Sci-Fi", 148, "M12", "Em exibição", "Sonhos em camadas");
        Lugar l1 = new Lugar("A", 1);
        Lugar l2 = new Lugar("A", 2);
        Sessao sessao = new Sessao(1, Arrays.asList(l1, l2));

        GestorSessao gestor = new GestorSessao();
        gestor.adicionarSessao(filme, sessao);

        List<Sessao> resultado = gestor.visualizarTodasAsSessoes();
        assertEquals(1, resultado.size());
    }

    @Test
    public void testObterSessoesPorFilme() {
        Filme f1 = new Filme("Avatar", "Fantasia", 180, "M12", "Em exibição", "Pandora");
        Filme f2 = new Filme("Titanic", "Romance", 195, "M14", "Removido", "Iceberg");

        Sessao s1 = new Sessao(1, Collections.singletonList(new Lugar("B", 1)));
        Sessao s2 = new Sessao(2, Collections.singletonList(new Lugar("C", 2)));

        GestorSessao gestor = new GestorSessao();
        gestor.adicionarSessao(f1, s1);
        gestor.adicionarSessao(f1, s2);

        assertEquals(2, gestor.obterSessoesPorFilme(f1).size());
        assertTrue(gestor.obterSessoesPorFilme(f2).isEmpty());
    }

    @Test
    public void testSessaoComLugarDisponivel() {
        Lugar l = new Lugar("D", 1);
        Sessao s = new Sessao(5, Collections.singletonList(l));
        assertTrue(s.lugarDisponivel(l));
    }

    @Test
    public void testSessaoComLugarOcupado() {
        Lugar l = new Lugar("E", 2);
        l.reservar();
        Sessao s = new Sessao(6, Collections.singletonList(l));
        assertFalse(s.lugarDisponivel(l));
    }
}